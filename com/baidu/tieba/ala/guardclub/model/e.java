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
    private boolean eIz;
    private a fyj;
    private com.baidu.tieba.ala.guardclub.view.d fzM;
    private b fzO;
    private boolean hasMore;
    private int fzN = 1;
    private HttpMessageListener fzP = new HttpMessageListener(1021139) { // from class: com.baidu.tieba.ala.guardclub.model.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubJoinListHttpResponseMessage)) {
                if (e.this.fzM != null) {
                    e.this.fzM.bpd();
                    return;
                }
                return;
            }
            GuardClubJoinListHttpResponseMessage guardClubJoinListHttpResponseMessage = (GuardClubJoinListHttpResponseMessage) httpResponsedMessage;
            if (guardClubJoinListHttpResponseMessage.getError() != 0) {
                if (e.this.fzM != null) {
                    e.this.fzM.bpd();
                    return;
                }
                return;
            }
            e.this.hasMore = guardClubJoinListHttpResponseMessage.hasMore;
            if (e.this.fzM != null) {
                if (e.this.eIz) {
                    e.this.fzM.by(guardClubJoinListHttpResponseMessage.fzK);
                    e.this.fzM.completePullRefresh();
                } else {
                    e.this.fzM.bz(guardClubJoinListHttpResponseMessage.fzK);
                }
                if (guardClubJoinListHttpResponseMessage.hasMore) {
                    e.this.fzM.buA();
                } else if (!e.this.eIz) {
                    e.this.fzM.jZ(e.this.fzN == 1);
                }
                e.this.fzN++;
            }
        }
    };
    private HttpMessageListener fzQ = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.guardclub.model.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubQuitHttpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == e.this.unique_id && httpResponsedMessage.getError() == 0 && e.this.fzO != null) {
                e.this.fzO.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
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
        this.fyj = aVar;
        buJ();
        buK();
        MessageManager.getInstance().registerListener(this.fzP);
        MessageManager.getInstance().registerListener(this.fzQ);
    }

    public void a(com.baidu.tieba.ala.guardclub.view.d dVar) {
        this.fzM = dVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean buF() {
        return this.hasMore;
    }

    public void buG() {
        ka(true);
    }

    public void ka(boolean z) {
        this.eIz = z;
        if (z) {
            this.fzN = 1;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            buI();
        } else if (this.fzM != null) {
            this.fzM.bpd();
        }
    }

    public void buH() {
        this.eIz = false;
        if (this.fzM != null) {
            this.fzM.bqM();
            buI();
        }
    }

    private void buI() {
        f fVar = new f();
        fVar.setPn(this.fzN);
        fVar.setPs(20);
        fVar.setParams();
        fVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(fVar);
    }

    public void a(String str, b bVar) {
        j jVar = new j();
        jVar.BT(str);
        jVar.setParams();
        jVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(jVar);
        this.fzO = bVar;
    }

    private void buJ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021139, TbConfig.SERVER_HOST + "liveserver/guardClub/joinlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void buK() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/guardClub/quit");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GuardClubQuitHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.fzP != null) {
            MessageManager.getInstance().unRegisterListener(this.fzP);
        }
        if (this.fzQ != null) {
            MessageManager.getInstance().unRegisterListener(this.fzP);
        }
        MessageManager.getInstance().unRegisterTask(1021139);
    }
}
