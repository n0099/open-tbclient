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
/* loaded from: classes7.dex */
public class e extends BdBaseModel<GuardClubJoinListActivity> {
    private boolean fkC;
    private a gaR;
    private com.baidu.tieba.ala.guardclub.view.d gcr;
    private b gct;
    private boolean hasMore;
    private int gcs = 1;
    private HttpMessageListener gcu = new HttpMessageListener(1021139) { // from class: com.baidu.tieba.ala.guardclub.model.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubJoinListHttpResponseMessage)) {
                if (e.this.gcr != null) {
                    e.this.gcr.bDG();
                    return;
                }
                return;
            }
            GuardClubJoinListHttpResponseMessage guardClubJoinListHttpResponseMessage = (GuardClubJoinListHttpResponseMessage) httpResponsedMessage;
            if (guardClubJoinListHttpResponseMessage.getError() != 0) {
                if (e.this.gcr != null) {
                    e.this.gcr.bDG();
                    return;
                }
                return;
            }
            e.this.hasMore = guardClubJoinListHttpResponseMessage.hasMore;
            if (e.this.gcr != null) {
                if (e.this.fkC) {
                    e.this.gcr.bM(guardClubJoinListHttpResponseMessage.gcp);
                    e.this.gcr.completePullRefresh();
                } else {
                    e.this.gcr.bN(guardClubJoinListHttpResponseMessage.gcp);
                }
                if (guardClubJoinListHttpResponseMessage.hasMore) {
                    e.this.gcr.bKi();
                } else if (!e.this.fkC) {
                    e.this.gcr.lt(e.this.gcs == 1);
                }
                e.this.gcs++;
            }
        }
    };
    private HttpMessageListener gcv = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.guardclub.model.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubQuitHttpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == e.this.unique_id && httpResponsedMessage.getError() == 0 && e.this.gct != null) {
                e.this.gct.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
            }
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
    }

    /* loaded from: classes7.dex */
    public interface b {
        void b(int i, String str, Object obj);
    }

    public e(BdUniqueId bdUniqueId, a aVar) {
        this.unique_id = bdUniqueId;
        this.gaR = aVar;
        bKq();
        bKr();
        MessageManager.getInstance().registerListener(this.gcu);
        MessageManager.getInstance().registerListener(this.gcv);
    }

    public void a(com.baidu.tieba.ala.guardclub.view.d dVar) {
        this.gcr = dVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bKm() {
        return this.hasMore;
    }

    public void bKn() {
        lu(true);
    }

    public void lu(boolean z) {
        this.fkC = z;
        if (z) {
            this.gcs = 1;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            bKp();
        } else if (this.gcr != null) {
            this.gcr.bDG();
        }
    }

    public void bKo() {
        this.fkC = false;
        if (this.gcr != null) {
            this.gcr.bFT();
            bKp();
        }
    }

    private void bKp() {
        f fVar = new f();
        fVar.setPn(this.gcs);
        fVar.setPs(20);
        fVar.setParams();
        fVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(fVar);
    }

    public void a(String str, b bVar) {
        j jVar = new j();
        jVar.Fz(str);
        jVar.setParams();
        jVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(jVar);
        this.gct = bVar;
    }

    private void bKq() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021139, TbConfig.SERVER_HOST + "liveserver/guardClub/joinlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bKr() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/guardClub/quit");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GuardClubQuitHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.gcu != null) {
            MessageManager.getInstance().unRegisterListener(this.gcu);
        }
        if (this.gcv != null) {
            MessageManager.getInstance().unRegisterListener(this.gcu);
        }
        MessageManager.getInstance().unRegisterTask(1021139);
    }
}
