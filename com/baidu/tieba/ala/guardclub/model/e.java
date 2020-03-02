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
    private boolean dTi;
    private a eFj;
    private com.baidu.tieba.ala.guardclub.view.d eGP;
    private b eGR;
    private boolean hasMore;
    private int eGQ = 1;
    private HttpMessageListener eGS = new HttpMessageListener(1021139) { // from class: com.baidu.tieba.ala.guardclub.model.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubJoinListHttpResponseMessage)) {
                if (e.this.eGP != null) {
                    e.this.eGP.bbB();
                    return;
                }
                return;
            }
            GuardClubJoinListHttpResponseMessage guardClubJoinListHttpResponseMessage = (GuardClubJoinListHttpResponseMessage) httpResponsedMessage;
            if (guardClubJoinListHttpResponseMessage.getError() != 0) {
                if (e.this.eGP != null) {
                    e.this.eGP.bbB();
                    return;
                }
                return;
            }
            e.this.hasMore = guardClubJoinListHttpResponseMessage.hasMore;
            if (e.this.eGP != null) {
                if (e.this.dTi) {
                    e.this.eGP.bs(guardClubJoinListHttpResponseMessage.eGN);
                    e.this.eGP.completePullRefresh();
                } else {
                    e.this.eGP.bt(guardClubJoinListHttpResponseMessage.eGN);
                }
                if (guardClubJoinListHttpResponseMessage.hasMore) {
                    e.this.eGP.bfl();
                } else if (!e.this.dTi) {
                    e.this.eGP.iD(e.this.eGQ == 1);
                }
                e.this.eGQ++;
            }
        }
    };
    private HttpMessageListener eGT = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.guardclub.model.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubQuitHttpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == e.this.unique_id && httpResponsedMessage.getError() == 0 && e.this.eGR != null) {
                e.this.eGR.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
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
        this.eFj = aVar;
        bfu();
        bfv();
        MessageManager.getInstance().registerListener(this.eGS);
        MessageManager.getInstance().registerListener(this.eGT);
    }

    public void a(com.baidu.tieba.ala.guardclub.view.d dVar) {
        this.eGP = dVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bfq() {
        return this.hasMore;
    }

    public void bfr() {
        iE(true);
    }

    public void iE(boolean z) {
        this.dTi = z;
        if (z) {
            this.eGQ = 1;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            bft();
        } else if (this.eGP != null) {
            this.eGP.bbB();
        }
    }

    public void bfs() {
        this.dTi = false;
        if (this.eGP != null) {
            this.eGP.bcu();
            bft();
        }
    }

    private void bft() {
        f fVar = new f();
        fVar.setPn(this.eGQ);
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
        this.eGR = bVar;
    }

    private void bfu() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021139, TbConfig.SERVER_HOST + "liveserver/guardClub/joinlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bfv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/guardClub/quit");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GuardClubQuitHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.eGS != null) {
            MessageManager.getInstance().unRegisterListener(this.eGS);
        }
        if (this.eGT != null) {
            MessageManager.getInstance().unRegisterListener(this.eGS);
        }
        MessageManager.getInstance().unRegisterTask(1021139);
    }
}
