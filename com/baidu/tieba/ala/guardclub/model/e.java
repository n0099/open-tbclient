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
/* loaded from: classes4.dex */
public class e extends BdBaseModel<GuardClubJoinListActivity> {
    private boolean fNU;
    private a gGn;
    private com.baidu.tieba.ala.guardclub.view.d gHL;
    private b gHN;
    private boolean hasMore;
    private int gHM = 1;
    private HttpMessageListener gHO = new HttpMessageListener(1021139) { // from class: com.baidu.tieba.ala.guardclub.model.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubJoinListHttpResponseMessage)) {
                if (e.this.gHL != null) {
                    e.this.gHL.bLV();
                    return;
                }
                return;
            }
            GuardClubJoinListHttpResponseMessage guardClubJoinListHttpResponseMessage = (GuardClubJoinListHttpResponseMessage) httpResponsedMessage;
            if (guardClubJoinListHttpResponseMessage.getError() != 0) {
                if (e.this.gHL != null) {
                    e.this.gHL.bLV();
                    return;
                }
                return;
            }
            e.this.hasMore = guardClubJoinListHttpResponseMessage.hasMore;
            if (e.this.gHL != null) {
                if (e.this.fNU) {
                    e.this.gHL.cl(guardClubJoinListHttpResponseMessage.gHJ);
                    e.this.gHL.completePullRefresh();
                } else {
                    e.this.gHL.cm(guardClubJoinListHttpResponseMessage.gHJ);
                }
                if (guardClubJoinListHttpResponseMessage.hasMore) {
                    e.this.gHL.bTh();
                } else if (!e.this.fNU) {
                    e.this.gHL.ms(e.this.gHM == 1);
                }
                e.this.gHM++;
            }
        }
    };
    private HttpMessageListener gHP = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.guardclub.model.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubQuitHttpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == e.this.unique_id && httpResponsedMessage.getError() == 0 && e.this.gHN != null) {
                e.this.gHN.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
    }

    /* loaded from: classes4.dex */
    public interface b {
        void b(int i, String str, Object obj);
    }

    public e(BdUniqueId bdUniqueId, a aVar) {
        this.unique_id = bdUniqueId;
        this.gGn = aVar;
        bTo();
        bTp();
        MessageManager.getInstance().registerListener(this.gHO);
        MessageManager.getInstance().registerListener(this.gHP);
    }

    public void a(com.baidu.tieba.ala.guardclub.view.d dVar) {
        this.gHL = dVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bTk() {
        return this.hasMore;
    }

    public void bTl() {
        mt(true);
    }

    public void mt(boolean z) {
        this.fNU = z;
        if (z) {
            this.gHM = 1;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            bTn();
        } else if (this.gHL != null) {
            this.gHL.bLV();
        }
    }

    public void bTm() {
        this.fNU = false;
        if (this.gHL != null) {
            this.gHL.bOX();
            bTn();
        }
    }

    private void bTn() {
        f fVar = new f();
        fVar.setPn(this.gHM);
        fVar.setPs(20);
        fVar.setParams();
        fVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(fVar);
    }

    public void a(String str, b bVar) {
        j jVar = new j();
        jVar.Hs(str);
        jVar.setParams();
        jVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(jVar);
        this.gHN = bVar;
    }

    private void bTo() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021139, TbConfig.SERVER_HOST + "liveserver/guardClub/joinlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bTp() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/guardClub/quit");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GuardClubQuitHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.gHO != null) {
            MessageManager.getInstance().unRegisterListener(this.gHO);
        }
        if (this.gHP != null) {
            MessageManager.getInstance().unRegisterListener(this.gHO);
        }
        MessageManager.getInstance().unRegisterTask(1021139);
    }
}
