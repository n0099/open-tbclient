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
/* loaded from: classes3.dex */
public class g extends BdBaseModel<GuardClubMemberListActivity> {
    private boolean eIz;
    private a fyt;
    private boolean fyv;
    private com.baidu.tieba.ala.guardclub.k fzT;
    private long fzU;
    private boolean hasMore;
    private int fzN = 1;
    private HttpMessageListener fzV = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (g.this.fzT != null) {
                    g.this.fzT.bpd();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (g.this.fzT != null) {
                    g.this.fzT.bpd();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && g.this.fyt != null) {
                g.this.fyt.qp(guardClubMemberListHttpResponseMessage.memberCount);
            }
            g.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (g.this.fzT != null) {
                g.this.fzT.a(guardClubMemberListHttpResponseMessage.aOJ, guardClubMemberListHttpResponseMessage.aOM);
                if (!g.this.eIz || guardClubMemberListHttpResponseMessage.fzL != 1) {
                    g.this.fzT.bB(guardClubMemberListHttpResponseMessage.fzS);
                } else {
                    g.this.fzT.bA(guardClubMemberListHttpResponseMessage.fzS);
                    g.this.fzT.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    g.this.fzT.buA();
                } else {
                    g.this.fzT.jZ(g.this.fzN == 1);
                }
                g.this.fzN++;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void qp(int i);
    }

    public g(long j, boolean z, a aVar) {
        this.fzU = j;
        this.fyv = z;
        this.fyt = aVar;
        buJ();
        MessageManager.getInstance().registerListener(this.fzV);
    }

    public void k(com.baidu.tieba.ala.guardclub.k kVar) {
        this.fzT = kVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean buF() {
        return this.hasMore;
    }

    public void buG() {
        ka(true);
    }

    public void ka(boolean z) {
        this.eIz = z;
        if (z) {
            this.fzN = 1;
        }
        buL();
    }

    public void buH() {
        this.eIz = false;
        if (this.fzT != null) {
            this.fzT.bqM();
            buL();
        }
    }

    private void buL() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.fzT != null) {
            this.fzT.buB();
            return;
        }
        h hVar = new h();
        hVar.af(this.fzU);
        hVar.setPn(this.fzN);
        if (this.fyv) {
            hVar.setPs(20);
        } else {
            hVar.setPs(10);
        }
        hVar.setParams();
        MessageManager.getInstance().sendMessage(hVar);
    }

    private void buJ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.fzV != null) {
            MessageManager.getInstance().unRegisterListener(this.fzV);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
