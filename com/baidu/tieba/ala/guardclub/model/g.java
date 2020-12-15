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
    private boolean fVi;
    private a gPm;
    private boolean gPo;
    private com.baidu.tieba.ala.guardclub.l gQI;
    private long gQJ;
    private boolean hasMore;
    private int gQC = 1;
    private HttpMessageListener gQK = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (g.this.gQI != null) {
                    g.this.gQI.bOY();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (g.this.gQI != null) {
                    g.this.gQI.bOY();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && g.this.gPm != null) {
                g.this.gPm.vO(guardClubMemberListHttpResponseMessage.memberCount);
            }
            g.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (g.this.gQI != null) {
                g.this.gQI.a(guardClubMemberListHttpResponseMessage.bjf, guardClubMemberListHttpResponseMessage.bji);
                if (!g.this.fVi || guardClubMemberListHttpResponseMessage.gQA != 1) {
                    g.this.gQI.cs(guardClubMemberListHttpResponseMessage.gQH);
                } else {
                    g.this.gQI.cr(guardClubMemberListHttpResponseMessage.gQH);
                    g.this.gQI.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    g.this.gQI.bWl();
                } else {
                    g.this.gQI.mO(g.this.gQC == 1);
                }
                g.this.gQC++;
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void vO(int i);
    }

    public g(long j, boolean z, a aVar) {
        this.gQJ = j;
        this.gPo = z;
        this.gPm = aVar;
        bWs();
        MessageManager.getInstance().registerListener(this.gQK);
    }

    public void k(com.baidu.tieba.ala.guardclub.l lVar) {
        this.gQI = lVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bWo() {
        return this.hasMore;
    }

    public void bWp() {
        mP(true);
    }

    public void mP(boolean z) {
        this.fVi = z;
        if (z) {
            this.gQC = 1;
        }
        bWu();
    }

    public void bWq() {
        this.fVi = false;
        if (this.gQI != null) {
            this.gQI.bSc();
            bWu();
        }
    }

    private void bWu() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.gQI != null) {
            this.gQI.Tn();
            return;
        }
        h hVar = new h();
        hVar.setAnchorId(this.gQJ);
        hVar.setPn(this.gQC);
        if (this.gPo) {
            hVar.setPs(20);
        } else {
            hVar.setPs(10);
        }
        hVar.setParams();
        MessageManager.getInstance().sendMessage(hVar);
    }

    private void bWs() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.gQK != null) {
            MessageManager.getInstance().unRegisterListener(this.gQK);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
