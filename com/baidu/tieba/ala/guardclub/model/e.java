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
    private boolean fIe;
    private a gAz;
    private com.baidu.tieba.ala.guardclub.view.d gBX;
    private b gBZ;
    private boolean hasMore;
    private int gBY = 1;
    private HttpMessageListener gCa = new HttpMessageListener(1021139) { // from class: com.baidu.tieba.ala.guardclub.model.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubJoinListHttpResponseMessage)) {
                if (e.this.gBX != null) {
                    e.this.gBX.bJw();
                    return;
                }
                return;
            }
            GuardClubJoinListHttpResponseMessage guardClubJoinListHttpResponseMessage = (GuardClubJoinListHttpResponseMessage) httpResponsedMessage;
            if (guardClubJoinListHttpResponseMessage.getError() != 0) {
                if (e.this.gBX != null) {
                    e.this.gBX.bJw();
                    return;
                }
                return;
            }
            e.this.hasMore = guardClubJoinListHttpResponseMessage.hasMore;
            if (e.this.gBX != null) {
                if (e.this.fIe) {
                    e.this.gBX.ce(guardClubJoinListHttpResponseMessage.gBV);
                    e.this.gBX.completePullRefresh();
                } else {
                    e.this.gBX.cf(guardClubJoinListHttpResponseMessage.gBV);
                }
                if (guardClubJoinListHttpResponseMessage.hasMore) {
                    e.this.gBX.bQH();
                } else if (!e.this.fIe) {
                    e.this.gBX.mj(e.this.gBY == 1);
                }
                e.this.gBY++;
            }
        }
    };
    private HttpMessageListener gCb = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.guardclub.model.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubQuitHttpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == e.this.unique_id && httpResponsedMessage.getError() == 0 && e.this.gBZ != null) {
                e.this.gBZ.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
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
        this.gAz = aVar;
        bQP();
        bQQ();
        MessageManager.getInstance().registerListener(this.gCa);
        MessageManager.getInstance().registerListener(this.gCb);
    }

    public void a(com.baidu.tieba.ala.guardclub.view.d dVar) {
        this.gBX = dVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bQL() {
        return this.hasMore;
    }

    public void bQM() {
        mk(true);
    }

    public void mk(boolean z) {
        this.fIe = z;
        if (z) {
            this.gBY = 1;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            bQO();
        } else if (this.gBX != null) {
            this.gBX.bJw();
        }
    }

    public void bQN() {
        this.fIe = false;
        if (this.gBX != null) {
            this.gBX.bMx();
            bQO();
        }
    }

    private void bQO() {
        f fVar = new f();
        fVar.setPn(this.gBY);
        fVar.setPs(20);
        fVar.setParams();
        fVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(fVar);
    }

    public void a(String str, b bVar) {
        j jVar = new j();
        jVar.Hf(str);
        jVar.setParams();
        jVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(jVar);
        this.gBZ = bVar;
    }

    private void bQP() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021139, TbConfig.SERVER_HOST + "liveserver/guardClub/joinlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bQQ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/guardClub/quit");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GuardClubQuitHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.gCa != null) {
            MessageManager.getInstance().unRegisterListener(this.gCa);
        }
        if (this.gCb != null) {
            MessageManager.getInstance().unRegisterListener(this.gCa);
        }
        MessageManager.getInstance().unRegisterTask(1021139);
    }
}
