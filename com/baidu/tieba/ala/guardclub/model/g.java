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
/* loaded from: classes10.dex */
public class g extends BdBaseModel<GuardClubMemberListActivity> {
    private boolean gec;
    private boolean hasMore;
    private a hba;
    private boolean hbc;
    private com.baidu.tieba.ala.guardclub.l hcw;
    private long hcx;
    private int hcq = 1;
    private HttpMessageListener hcy = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (g.this.hcw != null) {
                    g.this.hcw.bOv();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (g.this.hcw != null) {
                    g.this.hcw.bOv();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && g.this.hba != null) {
                g.this.hba.uB(guardClubMemberListHttpResponseMessage.memberCount);
            }
            g.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (g.this.hcw != null) {
                g.this.hcw.a(guardClubMemberListHttpResponseMessage.bkD, guardClubMemberListHttpResponseMessage.bkG);
                if (!g.this.gec || guardClubMemberListHttpResponseMessage.hco != 1) {
                    g.this.hcw.cu(guardClubMemberListHttpResponseMessage.hcv);
                } else {
                    g.this.hcw.ct(guardClubMemberListHttpResponseMessage.hcv);
                    g.this.hcw.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    g.this.hcw.bVR();
                } else {
                    g.this.hcw.np(g.this.hcq == 1);
                }
                g.this.hcq++;
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void uB(int i);
    }

    public g(long j, boolean z, a aVar) {
        this.hcx = j;
        this.hbc = z;
        this.hba = aVar;
        bVY();
        MessageManager.getInstance().registerListener(this.hcy);
    }

    public void k(com.baidu.tieba.ala.guardclub.l lVar) {
        this.hcw = lVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bVU() {
        return this.hasMore;
    }

    public void bVV() {
        nq(true);
    }

    public void nq(boolean z) {
        this.gec = z;
        if (z) {
            this.hcq = 1;
        }
        bWa();
    }

    public void bVW() {
        this.gec = false;
        if (this.hcw != null) {
            this.hcw.bRE();
            bWa();
        }
    }

    private void bWa() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.hcw != null) {
            this.hcw.Sk();
            return;
        }
        h hVar = new h();
        hVar.setAnchorId(this.hcx);
        hVar.setPn(this.hcq);
        if (this.hbc) {
            hVar.setPs(20);
        } else {
            hVar.setPs(10);
        }
        hVar.setParams();
        MessageManager.getInstance().sendMessage(hVar);
    }

    private void bVY() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.hcy != null) {
            MessageManager.getInstance().unRegisterListener(this.hcy);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
