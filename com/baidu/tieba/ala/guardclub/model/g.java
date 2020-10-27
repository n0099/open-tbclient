package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.guardclub.GuardClubMemberListActivity;
/* loaded from: classes4.dex */
public class g extends BdBaseModel<GuardClubMemberListActivity> {
    private boolean fIe;
    private a gAI;
    private boolean gAK;
    private com.baidu.tieba.ala.guardclub.k gCe;
    private long gCf;
    private boolean hasMore;
    private int gBY = 1;
    private HttpMessageListener gCg = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (g.this.gCe != null) {
                    g.this.gCe.bJw();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (g.this.gCe != null) {
                    g.this.gCe.bJw();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && g.this.gAI != null) {
                g.this.gAI.uz(guardClubMemberListHttpResponseMessage.memberCount);
            }
            g.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (g.this.gCe != null) {
                g.this.gCe.a(guardClubMemberListHttpResponseMessage.bfh, guardClubMemberListHttpResponseMessage.bfk);
                if (!g.this.fIe || guardClubMemberListHttpResponseMessage.gBW != 1) {
                    g.this.gCe.ch(guardClubMemberListHttpResponseMessage.gCd);
                } else {
                    g.this.gCe.cg(guardClubMemberListHttpResponseMessage.gCd);
                    g.this.gCe.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    g.this.gCe.bQH();
                } else {
                    g.this.gCe.mj(g.this.gBY == 1);
                }
                g.this.gBY++;
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void uz(int i);
    }

    public g(long j, boolean z, a aVar) {
        this.gCf = j;
        this.gAK = z;
        this.gAI = aVar;
        bQP();
        MessageManager.getInstance().registerListener(this.gCg);
    }

    public void k(com.baidu.tieba.ala.guardclub.k kVar) {
        this.gCe = kVar;
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
        bQR();
    }

    public void bQN() {
        this.fIe = false;
        if (this.gCe != null) {
            this.gCe.bMx();
            bQR();
        }
    }

    private void bQR() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.gCe != null) {
            this.gCe.bQI();
            return;
        }
        h hVar = new h();
        hVar.setAnchorId(this.gCf);
        hVar.setPn(this.gBY);
        if (this.gAK) {
            hVar.setPs(20);
        } else {
            hVar.setPs(10);
        }
        hVar.setParams();
        MessageManager.getInstance().sendMessage(hVar);
    }

    private void bQP() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.gCg != null) {
            MessageManager.getInstance().unRegisterListener(this.gCg);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
