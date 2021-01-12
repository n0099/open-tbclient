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
/* loaded from: classes10.dex */
public class e extends BdBaseModel<GuardClubJoinListActivity> {
    private a gWk;
    private com.baidu.tieba.ala.guardclub.view.d gXI;
    private b gXK;
    private boolean gae;
    private boolean hasMore;
    private int gXJ = 1;
    private HttpMessageListener gXL = new HttpMessageListener(1021139) { // from class: com.baidu.tieba.ala.guardclub.model.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubJoinListHttpResponseMessage)) {
                if (e.this.gXI != null) {
                    e.this.gXI.bNH();
                    return;
                }
                return;
            }
            GuardClubJoinListHttpResponseMessage guardClubJoinListHttpResponseMessage = (GuardClubJoinListHttpResponseMessage) httpResponsedMessage;
            if (guardClubJoinListHttpResponseMessage.getError() != 0) {
                if (e.this.gXI != null) {
                    e.this.gXI.bNH();
                    return;
                }
                return;
            }
            e.this.hasMore = guardClubJoinListHttpResponseMessage.hasMore;
            if (e.this.gXI != null) {
                if (e.this.gae) {
                    e.this.gXI.cw(guardClubJoinListHttpResponseMessage.gXG);
                    e.this.gXI.completePullRefresh();
                } else {
                    e.this.gXI.cx(guardClubJoinListHttpResponseMessage.gXG);
                }
                if (guardClubJoinListHttpResponseMessage.hasMore) {
                    e.this.gXI.bUZ();
                } else if (!e.this.gae) {
                    e.this.gXI.nk(e.this.gXJ == 1);
                }
                e.this.gXJ++;
            }
        }
    };
    private HttpMessageListener gXM = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.guardclub.model.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubQuitHttpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == e.this.unique_id && httpResponsedMessage.getError() == 0 && e.this.gXK != null) {
                e.this.gXK.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
    }

    /* loaded from: classes10.dex */
    public interface b {
        void b(int i, String str, Object obj);
    }

    public e(BdUniqueId bdUniqueId, a aVar) {
        this.unique_id = bdUniqueId;
        this.gWk = aVar;
        bVg();
        bVh();
        MessageManager.getInstance().registerListener(this.gXL);
        MessageManager.getInstance().registerListener(this.gXM);
    }

    public void a(com.baidu.tieba.ala.guardclub.view.d dVar) {
        this.gXI = dVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bVc() {
        return this.hasMore;
    }

    public void bVd() {
        nl(true);
    }

    public void nl(boolean z) {
        this.gae = z;
        if (z) {
            this.gXJ = 1;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            bVf();
        } else if (this.gXI != null) {
            this.gXI.bNH();
        }
    }

    public void bVe() {
        this.gae = false;
        if (this.gXI != null) {
            this.gXI.bQN();
            bVf();
        }
    }

    private void bVf() {
        f fVar = new f();
        fVar.setPn(this.gXJ);
        fVar.setPs(20);
        fVar.setParams();
        fVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(fVar);
    }

    public void a(String str, b bVar) {
        j jVar = new j();
        jVar.Gv(str);
        jVar.setParams();
        jVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(jVar);
        this.gXK = bVar;
    }

    private void bVg() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021139, TbConfig.SERVER_HOST + "liveserver/guardClub/joinlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bVh() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/guardClub/quit");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GuardClubQuitHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.gXL != null) {
            MessageManager.getInstance().unRegisterListener(this.gXL);
        }
        if (this.gXM != null) {
            MessageManager.getInstance().unRegisterListener(this.gXL);
        }
        MessageManager.getInstance().unRegisterTask(1021139);
    }
}
