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
/* loaded from: classes2.dex */
public class l extends BdBaseModel<GuardClubMemberListActivity> {
    private boolean dOT;
    private com.baidu.tieba.ala.guardclub.i eCa;
    private long eCb;
    private a ezT;
    private boolean ezV;
    private boolean hasMore;
    private int eBQ = 1;
    private HttpMessageListener eCc = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (l.this.eCa != null) {
                    l.this.eCa.aYQ();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (l.this.eCa != null) {
                    l.this.eCa.aYQ();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && l.this.ezT != null) {
                l.this.ezT.oY(guardClubMemberListHttpResponseMessage.memberCount);
            }
            l.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (l.this.eCa != null) {
                l.this.eCa.a(guardClubMemberListHttpResponseMessage.ezi, guardClubMemberListHttpResponseMessage.eBD);
                if (!l.this.dOT || guardClubMemberListHttpResponseMessage.eBO != 1) {
                    l.this.eCa.bv(guardClubMemberListHttpResponseMessage.eBZ);
                } else {
                    l.this.eCa.bu(guardClubMemberListHttpResponseMessage.eBZ);
                    l.this.eCa.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    l.this.eCa.bcz();
                } else {
                    l.this.eCa.im(l.this.eBQ == 1);
                }
                l.this.eBQ++;
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void oY(int i);
    }

    public l(long j, boolean z, a aVar) {
        this.eCb = j;
        this.ezV = z;
        this.ezT = aVar;
        bcP();
        MessageManager.getInstance().registerListener(this.eCc);
    }

    public void j(com.baidu.tieba.ala.guardclub.i iVar) {
        this.eCa = iVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bcL() {
        return this.hasMore;
    }

    public void bcM() {
        in(true);
    }

    public void in(boolean z) {
        this.dOT = z;
        if (z) {
            this.eBQ = 1;
        }
        bcR();
    }

    public void bcN() {
        this.dOT = false;
        if (this.eCa != null) {
            this.eCa.aZH();
            bcR();
        }
    }

    private void bcR() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.eCa != null) {
            this.eCa.bcA();
            return;
        }
        m mVar = new m();
        mVar.cu(this.eCb);
        mVar.setPn(this.eBQ);
        if (this.ezV) {
            mVar.setPs(20);
        } else {
            mVar.setPs(10);
        }
        mVar.setParams();
        MessageManager.getInstance().sendMessage(mVar);
    }

    private void bcP() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.eCc != null) {
            MessageManager.getInstance().unRegisterListener(this.eCc);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
