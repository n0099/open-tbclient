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
    private boolean eIo;
    private a fyi;
    private boolean fyk;
    private com.baidu.tieba.ala.guardclub.k fzI;
    private long fzJ;
    private boolean hasMore;
    private int fzC = 1;
    private HttpMessageListener fzK = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (g.this.fzI != null) {
                    g.this.fzI.bpb();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (g.this.fzI != null) {
                    g.this.fzI.bpb();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && g.this.fyi != null) {
                g.this.fyi.qn(guardClubMemberListHttpResponseMessage.memberCount);
            }
            g.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (g.this.fzI != null) {
                g.this.fzI.a(guardClubMemberListHttpResponseMessage.aOJ, guardClubMemberListHttpResponseMessage.aOM);
                if (!g.this.eIo || guardClubMemberListHttpResponseMessage.fzA != 1) {
                    g.this.fzI.bB(guardClubMemberListHttpResponseMessage.fzH);
                } else {
                    g.this.fzI.bA(guardClubMemberListHttpResponseMessage.fzH);
                    g.this.fzI.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    g.this.fzI.buy();
                } else {
                    g.this.fzI.jZ(g.this.fzC == 1);
                }
                g.this.fzC++;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void qn(int i);
    }

    public g(long j, boolean z, a aVar) {
        this.fzJ = j;
        this.fyk = z;
        this.fyi = aVar;
        buH();
        MessageManager.getInstance().registerListener(this.fzK);
    }

    public void k(com.baidu.tieba.ala.guardclub.k kVar) {
        this.fzI = kVar;
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
        buJ();
    }

    public void buF() {
        this.eIo = false;
        if (this.fzI != null) {
            this.fzI.bqK();
            buJ();
        }
    }

    private void buJ() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.fzI != null) {
            this.fzI.buz();
            return;
        }
        h hVar = new h();
        hVar.af(this.fzJ);
        hVar.setPn(this.fzC);
        if (this.fyk) {
            hVar.setPs(20);
        } else {
            hVar.setPs(10);
        }
        hVar.setParams();
        MessageManager.getInstance().sendMessage(hVar);
    }

    private void buH() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.fzK != null) {
            MessageManager.getInstance().unRegisterListener(this.fzK);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
