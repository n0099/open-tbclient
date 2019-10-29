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
    private boolean dMA;
    private a dMy;
    private com.baidu.tieba.ala.guardclub.i dOK;
    private long dOL;
    private boolean dbQ;
    private boolean hasMore;
    private int dOA = 1;
    private HttpMessageListener dOM = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (l.this.dOK != null) {
                    l.this.dOK.aLt();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (l.this.dOK != null) {
                    l.this.dOK.aLt();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && l.this.dMy != null) {
                l.this.dMy.mJ(guardClubMemberListHttpResponseMessage.memberCount);
            }
            l.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (l.this.dOK != null) {
                l.this.dOK.a(guardClubMemberListHttpResponseMessage.dLJ, guardClubMemberListHttpResponseMessage.dOm);
                if (!l.this.dbQ || guardClubMemberListHttpResponseMessage.dOy != 1) {
                    l.this.dOK.bw(guardClubMemberListHttpResponseMessage.dOJ);
                } else {
                    l.this.dOK.bv(guardClubMemberListHttpResponseMessage.dOJ);
                    l.this.dOK.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    l.this.dOK.aLr();
                } else {
                    l.this.dOK.hf(l.this.dOA == 1);
                }
                l.this.dOA++;
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void mJ(int i);
    }

    public l(long j, boolean z, a aVar) {
        this.dOL = j;
        this.dMA = z;
        this.dMy = aVar;
        aLI();
        MessageManager.getInstance().registerListener(this.dOM);
    }

    public void j(com.baidu.tieba.ala.guardclub.i iVar) {
        this.dOK = iVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean aLE() {
        return this.hasMore;
    }

    public void aLF() {
        hg(true);
    }

    public void hg(boolean z) {
        this.dbQ = z;
        if (z) {
            this.dOA = 1;
        }
        aLK();
    }

    public void aLG() {
        this.dbQ = false;
        if (this.dOK != null) {
            this.dOK.aJl();
            aLK();
        }
    }

    private void aLK() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.dOK != null) {
            this.dOK.aLs();
            return;
        }
        m mVar = new m();
        mVar.ca(this.dOL);
        mVar.setPn(this.dOA);
        if (this.dMA) {
            mVar.setPs(20);
        } else {
            mVar.setPs(10);
        }
        mVar.setParams();
        MessageManager.getInstance().sendMessage(mVar);
    }

    private void aLI() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.dOM != null) {
            MessageManager.getInstance().unRegisterListener(this.dOM);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
