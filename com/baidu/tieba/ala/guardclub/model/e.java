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
    private boolean dTL;
    private a eFS;
    private b eHA;
    private com.baidu.tieba.ala.guardclub.view.d eHy;
    private boolean hasMore;
    private int eHz = 1;
    private HttpMessageListener eHB = new HttpMessageListener(1021139) { // from class: com.baidu.tieba.ala.guardclub.model.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubJoinListHttpResponseMessage)) {
                if (e.this.eHy != null) {
                    e.this.eHy.bbG();
                    return;
                }
                return;
            }
            GuardClubJoinListHttpResponseMessage guardClubJoinListHttpResponseMessage = (GuardClubJoinListHttpResponseMessage) httpResponsedMessage;
            if (guardClubJoinListHttpResponseMessage.getError() != 0) {
                if (e.this.eHy != null) {
                    e.this.eHy.bbG();
                    return;
                }
                return;
            }
            e.this.hasMore = guardClubJoinListHttpResponseMessage.hasMore;
            if (e.this.eHy != null) {
                if (e.this.dTL) {
                    e.this.eHy.bs(guardClubJoinListHttpResponseMessage.eHw);
                    e.this.eHy.completePullRefresh();
                } else {
                    e.this.eHy.bt(guardClubJoinListHttpResponseMessage.eHw);
                }
                if (guardClubJoinListHttpResponseMessage.hasMore) {
                    e.this.eHy.bfr();
                } else if (!e.this.dTL) {
                    e.this.eHy.iF(e.this.eHz == 1);
                }
                e.this.eHz++;
            }
        }
    };
    private HttpMessageListener eHC = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.guardclub.model.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubQuitHttpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == e.this.unique_id && httpResponsedMessage.getError() == 0 && e.this.eHA != null) {
                e.this.eHA.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
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
        this.eFS = aVar;
        bfA();
        bfB();
        MessageManager.getInstance().registerListener(this.eHB);
        MessageManager.getInstance().registerListener(this.eHC);
    }

    public void a(com.baidu.tieba.ala.guardclub.view.d dVar) {
        this.eHy = dVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bfw() {
        return this.hasMore;
    }

    public void bfx() {
        iG(true);
    }

    public void iG(boolean z) {
        this.dTL = z;
        if (z) {
            this.eHz = 1;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            bfz();
        } else if (this.eHy != null) {
            this.eHy.bbG();
        }
    }

    public void bfy() {
        this.dTL = false;
        if (this.eHy != null) {
            this.eHy.bcz();
            bfz();
        }
    }

    private void bfz() {
        f fVar = new f();
        fVar.setPn(this.eHz);
        fVar.setPs(20);
        fVar.setParams();
        fVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(fVar);
    }

    public void a(String str, b bVar) {
        j jVar = new j();
        jVar.yB(str);
        jVar.setParams();
        jVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(jVar);
        this.eHA = bVar;
    }

    private void bfA() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021139, TbConfig.SERVER_HOST + "liveserver/guardClub/joinlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bfB() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/guardClub/quit");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GuardClubQuitHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.eHB != null) {
            MessageManager.getInstance().unRegisterListener(this.eHB);
        }
        if (this.eHC != null) {
            MessageManager.getInstance().unRegisterListener(this.eHB);
        }
        MessageManager.getInstance().unRegisterTask(1021139);
    }
}
