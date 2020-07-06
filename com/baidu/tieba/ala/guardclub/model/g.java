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
    private boolean eSL;
    private a fJD;
    private boolean fJF;
    private com.baidu.tieba.ala.guardclub.k fLc;
    private long fLd;
    private boolean hasMore;
    private int fKW = 1;
    private HttpMessageListener fLe = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (g.this.fLc != null) {
                    g.this.fLc.brE();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (g.this.fLc != null) {
                    g.this.fLc.brE();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && g.this.fJD != null) {
                g.this.fJD.qO(guardClubMemberListHttpResponseMessage.memberCount);
            }
            g.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (g.this.fLc != null) {
                g.this.fLc.a(guardClubMemberListHttpResponseMessage.aRp, guardClubMemberListHttpResponseMessage.aRs);
                if (!g.this.eSL || guardClubMemberListHttpResponseMessage.fKU != 1) {
                    g.this.fLc.bK(guardClubMemberListHttpResponseMessage.fLb);
                } else {
                    g.this.fLc.bJ(guardClubMemberListHttpResponseMessage.fLb);
                    g.this.fLc.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    g.this.fLc.bxw();
                } else {
                    g.this.fLc.kn(g.this.fKW == 1);
                }
                g.this.fKW++;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void qO(int i);
    }

    public g(long j, boolean z, a aVar) {
        this.fLd = j;
        this.fJF = z;
        this.fJD = aVar;
        bxF();
        MessageManager.getInstance().registerListener(this.fLe);
    }

    public void k(com.baidu.tieba.ala.guardclub.k kVar) {
        this.fLc = kVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bxB() {
        return this.hasMore;
    }

    public void bxC() {
        ko(true);
    }

    public void ko(boolean z) {
        this.eSL = z;
        if (z) {
            this.fKW = 1;
        }
        bxH();
    }

    public void bxD() {
        this.eSL = false;
        if (this.fLc != null) {
            this.fLc.btK();
            bxH();
        }
    }

    private void bxH() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.fLc != null) {
            this.fLc.bxx();
            return;
        }
        h hVar = new h();
        hVar.af(this.fLd);
        hVar.setPn(this.fKW);
        if (this.fJF) {
            hVar.setPs(20);
        } else {
            hVar.setPs(10);
        }
        hVar.setParams();
        MessageManager.getInstance().sendMessage(hVar);
    }

    private void bxF() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.fLe != null) {
            MessageManager.getInstance().unRegisterListener(this.fLe);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
