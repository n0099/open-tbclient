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
    private boolean dPb;
    private a eBe;
    private boolean eBg;
    private com.baidu.tieba.ala.guardclub.i eDl;
    private long eDm;
    private boolean hasMore;
    private int eDb = 1;
    private HttpMessageListener eDn = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (l.this.eDl != null) {
                    l.this.eDl.aZk();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (l.this.eDl != null) {
                    l.this.eDl.aZk();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && l.this.eBe != null) {
                l.this.eBe.oZ(guardClubMemberListHttpResponseMessage.memberCount);
            }
            l.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (l.this.eDl != null) {
                l.this.eDl.a(guardClubMemberListHttpResponseMessage.eAt, guardClubMemberListHttpResponseMessage.eCO);
                if (!l.this.dPb || guardClubMemberListHttpResponseMessage.eCZ != 1) {
                    l.this.eDl.bv(guardClubMemberListHttpResponseMessage.eDk);
                } else {
                    l.this.eDl.bu(guardClubMemberListHttpResponseMessage.eDk);
                    l.this.eDl.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    l.this.eDl.bcU();
                } else {
                    l.this.eDl.iw(l.this.eDb == 1);
                }
                l.this.eDb++;
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void oZ(int i);
    }

    public l(long j, boolean z, a aVar) {
        this.eDm = j;
        this.eBg = z;
        this.eBe = aVar;
        bdk();
        MessageManager.getInstance().registerListener(this.eDn);
    }

    public void j(com.baidu.tieba.ala.guardclub.i iVar) {
        this.eDl = iVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bdg() {
        return this.hasMore;
    }

    public void bdh() {
        ix(true);
    }

    public void ix(boolean z) {
        this.dPb = z;
        if (z) {
            this.eDb = 1;
        }
        bdm();
    }

    public void bdi() {
        this.dPb = false;
        if (this.eDl != null) {
            this.eDl.bac();
            bdm();
        }
    }

    private void bdm() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.eDl != null) {
            this.eDl.bcV();
            return;
        }
        m mVar = new m();
        mVar.cz(this.eDm);
        mVar.setPn(this.eDb);
        if (this.eBg) {
            mVar.setPs(20);
        } else {
            mVar.setPs(10);
        }
        mVar.setParams();
        MessageManager.getInstance().sendMessage(mVar);
    }

    private void bdk() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.eDn != null) {
            MessageManager.getInstance().unRegisterListener(this.eDn);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
