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
    private boolean dTh;
    private a eFi;
    private com.baidu.tieba.ala.guardclub.view.d eGO;
    private b eGQ;
    private boolean hasMore;
    private int eGP = 1;
    private HttpMessageListener eGR = new HttpMessageListener(1021139) { // from class: com.baidu.tieba.ala.guardclub.model.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubJoinListHttpResponseMessage)) {
                if (e.this.eGO != null) {
                    e.this.eGO.bbz();
                    return;
                }
                return;
            }
            GuardClubJoinListHttpResponseMessage guardClubJoinListHttpResponseMessage = (GuardClubJoinListHttpResponseMessage) httpResponsedMessage;
            if (guardClubJoinListHttpResponseMessage.getError() != 0) {
                if (e.this.eGO != null) {
                    e.this.eGO.bbz();
                    return;
                }
                return;
            }
            e.this.hasMore = guardClubJoinListHttpResponseMessage.hasMore;
            if (e.this.eGO != null) {
                if (e.this.dTh) {
                    e.this.eGO.bs(guardClubJoinListHttpResponseMessage.eGM);
                    e.this.eGO.completePullRefresh();
                } else {
                    e.this.eGO.bt(guardClubJoinListHttpResponseMessage.eGM);
                }
                if (guardClubJoinListHttpResponseMessage.hasMore) {
                    e.this.eGO.bfj();
                } else if (!e.this.dTh) {
                    e.this.eGO.iD(e.this.eGP == 1);
                }
                e.this.eGP++;
            }
        }
    };
    private HttpMessageListener eGS = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.guardclub.model.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubQuitHttpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == e.this.unique_id && httpResponsedMessage.getError() == 0 && e.this.eGQ != null) {
                e.this.eGQ.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
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
        this.eFi = aVar;
        bfs();
        bft();
        MessageManager.getInstance().registerListener(this.eGR);
        MessageManager.getInstance().registerListener(this.eGS);
    }

    public void a(com.baidu.tieba.ala.guardclub.view.d dVar) {
        this.eGO = dVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bfo() {
        return this.hasMore;
    }

    public void bfp() {
        iE(true);
    }

    public void iE(boolean z) {
        this.dTh = z;
        if (z) {
            this.eGP = 1;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            bfr();
        } else if (this.eGO != null) {
            this.eGO.bbz();
        }
    }

    public void bfq() {
        this.dTh = false;
        if (this.eGO != null) {
            this.eGO.bcs();
            bfr();
        }
    }

    private void bfr() {
        f fVar = new f();
        fVar.setPn(this.eGP);
        fVar.setPs(20);
        fVar.setParams();
        fVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(fVar);
    }

    public void a(String str, b bVar) {
        j jVar = new j();
        jVar.yz(str);
        jVar.setParams();
        jVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(jVar);
        this.eGQ = bVar;
    }

    private void bfs() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021139, TbConfig.SERVER_HOST + "liveserver/guardClub/joinlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bft() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/guardClub/quit");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GuardClubQuitHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.eGR != null) {
            MessageManager.getInstance().unRegisterListener(this.eGR);
        }
        if (this.eGS != null) {
            MessageManager.getInstance().unRegisterListener(this.eGR);
        }
        MessageManager.getInstance().unRegisterTask(1021139);
    }
}
