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
    private a gPk;
    private boolean gPm;
    private com.baidu.tieba.ala.guardclub.l gQG;
    private long gQH;
    private boolean hasMore;
    private int gQA = 1;
    private HttpMessageListener gQI = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (g.this.gQG != null) {
                    g.this.gQG.bOX();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (g.this.gQG != null) {
                    g.this.gQG.bOX();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && g.this.gPk != null) {
                g.this.gPk.vO(guardClubMemberListHttpResponseMessage.memberCount);
            }
            g.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (g.this.gQG != null) {
                g.this.gQG.a(guardClubMemberListHttpResponseMessage.bjf, guardClubMemberListHttpResponseMessage.bji);
                if (!g.this.fVi || guardClubMemberListHttpResponseMessage.gQy != 1) {
                    g.this.gQG.cs(guardClubMemberListHttpResponseMessage.gQF);
                } else {
                    g.this.gQG.cr(guardClubMemberListHttpResponseMessage.gQF);
                    g.this.gQG.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    g.this.gQG.bWk();
                } else {
                    g.this.gQG.mO(g.this.gQA == 1);
                }
                g.this.gQA++;
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void vO(int i);
    }

    public g(long j, boolean z, a aVar) {
        this.gQH = j;
        this.gPm = z;
        this.gPk = aVar;
        bWr();
        MessageManager.getInstance().registerListener(this.gQI);
    }

    public void k(com.baidu.tieba.ala.guardclub.l lVar) {
        this.gQG = lVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bWn() {
        return this.hasMore;
    }

    public void bWo() {
        mP(true);
    }

    public void mP(boolean z) {
        this.fVi = z;
        if (z) {
            this.gQA = 1;
        }
        bWt();
    }

    public void bWp() {
        this.fVi = false;
        if (this.gQG != null) {
            this.gQG.bSb();
            bWt();
        }
    }

    private void bWt() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.gQG != null) {
            this.gQG.Tn();
            return;
        }
        h hVar = new h();
        hVar.setAnchorId(this.gQH);
        hVar.setPn(this.gQA);
        if (this.gPm) {
            hVar.setPs(20);
        } else {
            hVar.setPs(10);
        }
        hVar.setParams();
        MessageManager.getInstance().sendMessage(hVar);
    }

    private void bWr() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.gQI != null) {
            MessageManager.getInstance().unRegisterListener(this.gQI);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
