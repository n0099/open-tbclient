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
    private boolean eIo;
    private a fxY;
    private com.baidu.tieba.ala.guardclub.view.d fzB;
    private b fzD;
    private boolean hasMore;
    private int fzC = 1;
    private HttpMessageListener fzE = new HttpMessageListener(1021139) { // from class: com.baidu.tieba.ala.guardclub.model.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubJoinListHttpResponseMessage)) {
                if (e.this.fzB != null) {
                    e.this.fzB.bpb();
                    return;
                }
                return;
            }
            GuardClubJoinListHttpResponseMessage guardClubJoinListHttpResponseMessage = (GuardClubJoinListHttpResponseMessage) httpResponsedMessage;
            if (guardClubJoinListHttpResponseMessage.getError() != 0) {
                if (e.this.fzB != null) {
                    e.this.fzB.bpb();
                    return;
                }
                return;
            }
            e.this.hasMore = guardClubJoinListHttpResponseMessage.hasMore;
            if (e.this.fzB != null) {
                if (e.this.eIo) {
                    e.this.fzB.by(guardClubJoinListHttpResponseMessage.fzz);
                    e.this.fzB.completePullRefresh();
                } else {
                    e.this.fzB.bz(guardClubJoinListHttpResponseMessage.fzz);
                }
                if (guardClubJoinListHttpResponseMessage.hasMore) {
                    e.this.fzB.buy();
                } else if (!e.this.eIo) {
                    e.this.fzB.jZ(e.this.fzC == 1);
                }
                e.this.fzC++;
            }
        }
    };
    private HttpMessageListener fzF = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.guardclub.model.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubQuitHttpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == e.this.unique_id && httpResponsedMessage.getError() == 0 && e.this.fzD != null) {
                e.this.fzD.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
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
        this.fxY = aVar;
        buH();
        buI();
        MessageManager.getInstance().registerListener(this.fzE);
        MessageManager.getInstance().registerListener(this.fzF);
    }

    public void a(com.baidu.tieba.ala.guardclub.view.d dVar) {
        this.fzB = dVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean buD() {
        return this.hasMore;
    }

    public void buE() {
        ka(true);
    }

    public void ka(boolean z) {
        this.eIo = z;
        if (z) {
            this.fzC = 1;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            buG();
        } else if (this.fzB != null) {
            this.fzB.bpb();
        }
    }

    public void buF() {
        this.eIo = false;
        if (this.fzB != null) {
            this.fzB.bqK();
            buG();
        }
    }

    private void buG() {
        f fVar = new f();
        fVar.setPn(this.fzC);
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
        this.fzD = bVar;
    }

    private void buH() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021139, TbConfig.SERVER_HOST + "liveserver/guardClub/joinlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void buI() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/guardClub/quit");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GuardClubQuitHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.fzE != null) {
            MessageManager.getInstance().unRegisterListener(this.fzE);
        }
        if (this.fzF != null) {
            MessageManager.getInstance().unRegisterListener(this.fzE);
        }
        MessageManager.getInstance().unRegisterTask(1021139);
    }
}
