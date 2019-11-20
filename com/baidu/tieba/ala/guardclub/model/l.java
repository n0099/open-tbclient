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
/* loaded from: classes6.dex */
public class l extends BdBaseModel<GuardClubMemberListActivity> {
    private a dLH;
    private boolean dLJ;
    private com.baidu.tieba.ala.guardclub.i dNT;
    private long dNU;
    private boolean daZ;
    private boolean hasMore;
    private int dNJ = 1;
    private HttpMessageListener dNV = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (l.this.dNT != null) {
                    l.this.dNT.aLr();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (l.this.dNT != null) {
                    l.this.dNT.aLr();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && l.this.dLH != null) {
                l.this.dLH.mI(guardClubMemberListHttpResponseMessage.memberCount);
            }
            l.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (l.this.dNT != null) {
                l.this.dNT.a(guardClubMemberListHttpResponseMessage.dKS, guardClubMemberListHttpResponseMessage.dNv);
                if (!l.this.daZ || guardClubMemberListHttpResponseMessage.dNH != 1) {
                    l.this.dNT.bw(guardClubMemberListHttpResponseMessage.dNS);
                } else {
                    l.this.dNT.bv(guardClubMemberListHttpResponseMessage.dNS);
                    l.this.dNT.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    l.this.dNT.aLp();
                } else {
                    l.this.dNT.hf(l.this.dNJ == 1);
                }
                l.this.dNJ++;
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void mI(int i);
    }

    public l(long j, boolean z, a aVar) {
        this.dNU = j;
        this.dLJ = z;
        this.dLH = aVar;
        aLG();
        MessageManager.getInstance().registerListener(this.dNV);
    }

    public void j(com.baidu.tieba.ala.guardclub.i iVar) {
        this.dNT = iVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean aLC() {
        return this.hasMore;
    }

    public void aLD() {
        hg(true);
    }

    public void hg(boolean z) {
        this.daZ = z;
        if (z) {
            this.dNJ = 1;
        }
        aLI();
    }

    public void aLE() {
        this.daZ = false;
        if (this.dNT != null) {
            this.dNT.aJj();
            aLI();
        }
    }

    private void aLI() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.dNT != null) {
            this.dNT.aLq();
            return;
        }
        m mVar = new m();
        mVar.bZ(this.dNU);
        mVar.setPn(this.dNJ);
        if (this.dLJ) {
            mVar.setPs(20);
        } else {
            mVar.setPs(10);
        }
        mVar.setParams();
        MessageManager.getInstance().sendMessage(mVar);
    }

    private void aLG() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.dNV != null) {
            MessageManager.getInstance().unRegisterListener(this.dNV);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
