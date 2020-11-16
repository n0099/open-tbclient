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
    private boolean fNx;
    private a gGd;
    private boolean gGf;
    private long gHA;
    private com.baidu.tieba.ala.guardclub.k gHz;
    private boolean hasMore;
    private int gHt = 1;
    private HttpMessageListener gHB = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (g.this.gHz != null) {
                    g.this.gHz.bLo();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (g.this.gHz != null) {
                    g.this.gHz.bLo();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && g.this.gGd != null) {
                g.this.gGd.vh(guardClubMemberListHttpResponseMessage.memberCount);
            }
            g.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (g.this.gHz != null) {
                g.this.gHz.a(guardClubMemberListHttpResponseMessage.beO, guardClubMemberListHttpResponseMessage.beR);
                if (!g.this.fNx || guardClubMemberListHttpResponseMessage.gHr != 1) {
                    g.this.gHz.co(guardClubMemberListHttpResponseMessage.gHy);
                } else {
                    g.this.gHz.cn(guardClubMemberListHttpResponseMessage.gHy);
                    g.this.gHz.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    g.this.gHz.bSA();
                } else {
                    g.this.gHz.mt(g.this.gHt == 1);
                }
                g.this.gHt++;
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void vh(int i);
    }

    public g(long j, boolean z, a aVar) {
        this.gHA = j;
        this.gGf = z;
        this.gGd = aVar;
        bSH();
        MessageManager.getInstance().registerListener(this.gHB);
    }

    public void k(com.baidu.tieba.ala.guardclub.k kVar) {
        this.gHz = kVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bSD() {
        return this.hasMore;
    }

    public void bSE() {
        mu(true);
    }

    public void mu(boolean z) {
        this.fNx = z;
        if (z) {
            this.gHt = 1;
        }
        bSJ();
    }

    public void bSF() {
        this.fNx = false;
        if (this.gHz != null) {
            this.gHz.bOq();
            bSJ();
        }
    }

    private void bSJ() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.gHz != null) {
            this.gHz.QP();
            return;
        }
        h hVar = new h();
        hVar.setAnchorId(this.gHA);
        hVar.setPn(this.gHt);
        if (this.gGf) {
            hVar.setPs(20);
        } else {
            hVar.setPs(10);
        }
        hVar.setParams();
        MessageManager.getInstance().sendMessage(hVar);
    }

    private void bSH() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.gHB != null) {
            MessageManager.getInstance().unRegisterListener(this.gHB);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
