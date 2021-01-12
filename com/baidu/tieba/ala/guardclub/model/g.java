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
    private a gWt;
    private boolean gWv;
    private com.baidu.tieba.ala.guardclub.l gXP;
    private long gXQ;
    private boolean gae;
    private boolean hasMore;
    private int gXJ = 1;
    private HttpMessageListener gXR = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (g.this.gXP != null) {
                    g.this.gXP.bNH();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (g.this.gXP != null) {
                    g.this.gXP.bNH();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && g.this.gWt != null) {
                g.this.gWt.ut(guardClubMemberListHttpResponseMessage.memberCount);
            }
            g.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (g.this.gXP != null) {
                g.this.gXP.a(guardClubMemberListHttpResponseMessage.bfU, guardClubMemberListHttpResponseMessage.bfX);
                if (!g.this.gae || guardClubMemberListHttpResponseMessage.gXH != 1) {
                    g.this.gXP.cz(guardClubMemberListHttpResponseMessage.gXO);
                } else {
                    g.this.gXP.cy(guardClubMemberListHttpResponseMessage.gXO);
                    g.this.gXP.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    g.this.gXP.bUZ();
                } else {
                    g.this.gXP.nk(g.this.gXJ == 1);
                }
                g.this.gXJ++;
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void ut(int i);
    }

    public g(long j, boolean z, a aVar) {
        this.gXQ = j;
        this.gWv = z;
        this.gWt = aVar;
        bVg();
        MessageManager.getInstance().registerListener(this.gXR);
    }

    public void k(com.baidu.tieba.ala.guardclub.l lVar) {
        this.gXP = lVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bVc() {
        return this.hasMore;
    }

    public void bVd() {
        nl(true);
    }

    public void nl(boolean z) {
        this.gae = z;
        if (z) {
            this.gXJ = 1;
        }
        bVi();
    }

    public void bVe() {
        this.gae = false;
        if (this.gXP != null) {
            this.gXP.bQN();
            bVi();
        }
    }

    private void bVi() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.gXP != null) {
            this.gXP.Qx();
            return;
        }
        h hVar = new h();
        hVar.setAnchorId(this.gXQ);
        hVar.setPn(this.gXJ);
        if (this.gWv) {
            hVar.setPs(20);
        } else {
            hVar.setPs(10);
        }
        hVar.setParams();
        MessageManager.getInstance().sendMessage(hVar);
    }

    private void bVg() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.gXR != null) {
            MessageManager.getInstance().unRegisterListener(this.gXR);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
