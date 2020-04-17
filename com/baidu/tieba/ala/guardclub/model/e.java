package com.baidu.tieba.ala.guardclub.model;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.guardclub.GuardClubJoinListActivity;
/* loaded from: classes3.dex */
public class e extends BdBaseModel<GuardClubJoinListActivity> {
    private boolean etK;
    private a fkn;
    private com.baidu.tieba.ala.guardclub.view.d flP;
    private b flR;
    private boolean hasMore;
    private int flQ = 1;
    private HttpMessageListener flS = new HttpMessageListener(1021139) { // from class: com.baidu.tieba.ala.guardclub.model.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubJoinListHttpResponseMessage)) {
                if (e.this.flP != null) {
                    e.this.flP.bjJ();
                    return;
                }
                return;
            }
            GuardClubJoinListHttpResponseMessage guardClubJoinListHttpResponseMessage = (GuardClubJoinListHttpResponseMessage) httpResponsedMessage;
            if (guardClubJoinListHttpResponseMessage.getError() != 0) {
                if (e.this.flP != null) {
                    e.this.flP.bjJ();
                    return;
                }
                return;
            }
            e.this.hasMore = guardClubJoinListHttpResponseMessage.hasMore;
            if (e.this.flP != null) {
                if (e.this.etK) {
                    e.this.flP.bB(guardClubJoinListHttpResponseMessage.flN);
                    e.this.flP.completePullRefresh();
                } else {
                    e.this.flP.bC(guardClubJoinListHttpResponseMessage.flN);
                }
                if (guardClubJoinListHttpResponseMessage.hasMore) {
                    e.this.flP.boI();
                } else if (!e.this.etK) {
                    e.this.flP.jG(e.this.flQ == 1);
                }
                e.this.flQ++;
            }
        }
    };
    private HttpMessageListener flT = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.guardclub.model.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubQuitHttpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == e.this.unique_id && httpResponsedMessage.getError() == 0 && e.this.flR != null) {
                e.this.flR.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
    }

    /* loaded from: classes3.dex */
    public interface b {
        void b(int i, String str, Object obj);
    }

    public e(BdUniqueId bdUniqueId, a aVar) {
        this.unique_id = bdUniqueId;
        this.fkn = aVar;
        boR();
        boS();
        MessageManager.getInstance().registerListener(this.flS);
        MessageManager.getInstance().registerListener(this.flT);
    }

    public void a(com.baidu.tieba.ala.guardclub.view.d dVar) {
        this.flP = dVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean boN() {
        return this.hasMore;
    }

    public void boO() {
        jH(true);
    }

    public void jH(boolean z) {
        this.etK = z;
        if (z) {
            this.flQ = 1;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            boQ();
        } else if (this.flP != null) {
            this.flP.bjJ();
        }
    }

    public void boP() {
        this.etK = false;
        if (this.flP != null) {
            this.flP.blq();
            boQ();
        }
    }

    private void boQ() {
        f fVar = new f();
        fVar.setPn(this.flQ);
        fVar.setPs(20);
        fVar.setParams();
        fVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(fVar);
    }

    public void a(String str, b bVar) {
        j jVar = new j();
        jVar.Aj(str);
        jVar.setParams();
        jVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(jVar);
        this.flR = bVar;
    }

    private void boR() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021139, TbConfig.SERVER_HOST + "liveserver/guardClub/joinlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void boS() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/guardClub/quit");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GuardClubQuitHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.flS != null) {
            MessageManager.getInstance().unRegisterListener(this.flS);
        }
        if (this.flT != null) {
            MessageManager.getInstance().unRegisterListener(this.flS);
        }
        MessageManager.getInstance().unRegisterTask(1021139);
    }
}
