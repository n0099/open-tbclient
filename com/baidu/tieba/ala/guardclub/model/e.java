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
    private boolean fky;
    private a gaN;
    private com.baidu.tieba.ala.guardclub.view.d gcn;
    private b gcp;
    private boolean hasMore;
    private int gco = 1;
    private HttpMessageListener gcq = new HttpMessageListener(1021139) { // from class: com.baidu.tieba.ala.guardclub.model.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubJoinListHttpResponseMessage)) {
                if (e.this.gcn != null) {
                    e.this.gcn.bDF();
                    return;
                }
                return;
            }
            GuardClubJoinListHttpResponseMessage guardClubJoinListHttpResponseMessage = (GuardClubJoinListHttpResponseMessage) httpResponsedMessage;
            if (guardClubJoinListHttpResponseMessage.getError() != 0) {
                if (e.this.gcn != null) {
                    e.this.gcn.bDF();
                    return;
                }
                return;
            }
            e.this.hasMore = guardClubJoinListHttpResponseMessage.hasMore;
            if (e.this.gcn != null) {
                if (e.this.fky) {
                    e.this.gcn.bM(guardClubJoinListHttpResponseMessage.gcl);
                    e.this.gcn.completePullRefresh();
                } else {
                    e.this.gcn.bN(guardClubJoinListHttpResponseMessage.gcl);
                }
                if (guardClubJoinListHttpResponseMessage.hasMore) {
                    e.this.gcn.bKh();
                } else if (!e.this.fky) {
                    e.this.gcn.lr(e.this.gco == 1);
                }
                e.this.gco++;
            }
        }
    };
    private HttpMessageListener gcr = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.guardclub.model.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubQuitHttpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == e.this.unique_id && httpResponsedMessage.getError() == 0 && e.this.gcp != null) {
                e.this.gcp.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
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
        this.gaN = aVar;
        bKp();
        bKq();
        MessageManager.getInstance().registerListener(this.gcq);
        MessageManager.getInstance().registerListener(this.gcr);
    }

    public void a(com.baidu.tieba.ala.guardclub.view.d dVar) {
        this.gcn = dVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bKl() {
        return this.hasMore;
    }

    public void bKm() {
        ls(true);
    }

    public void ls(boolean z) {
        this.fky = z;
        if (z) {
            this.gco = 1;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            bKo();
        } else if (this.gcn != null) {
            this.gcn.bDF();
        }
    }

    public void bKn() {
        this.fky = false;
        if (this.gcn != null) {
            this.gcn.bFS();
            bKo();
        }
    }

    private void bKo() {
        f fVar = new f();
        fVar.setPn(this.gco);
        fVar.setPs(20);
        fVar.setParams();
        fVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(fVar);
    }

    public void a(String str, b bVar) {
        j jVar = new j();
        jVar.Fy(str);
        jVar.setParams();
        jVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(jVar);
        this.gcp = bVar;
    }

    private void bKp() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021139, TbConfig.SERVER_HOST + "liveserver/guardClub/joinlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bKq() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/guardClub/quit");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GuardClubQuitHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.gcq != null) {
            MessageManager.getInstance().unRegisterListener(this.gcq);
        }
        if (this.gcr != null) {
            MessageManager.getInstance().unRegisterListener(this.gcq);
        }
        MessageManager.getInstance().unRegisterTask(1021139);
    }
}
