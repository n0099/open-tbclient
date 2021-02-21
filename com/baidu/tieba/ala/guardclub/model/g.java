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
/* loaded from: classes11.dex */
public class g extends BdBaseModel<GuardClubMemberListActivity> {
    private a gZr;
    private boolean gZt;
    private boolean gcC;
    private com.baidu.tieba.ala.guardclub.l haN;
    private long haO;
    private boolean hasMore;
    private int haH = 1;
    private HttpMessageListener haP = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (g.this.haN != null) {
                    g.this.haN.bOp();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (g.this.haN != null) {
                    g.this.haN.bOp();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && g.this.gZr != null) {
                g.this.gZr.uz(guardClubMemberListHttpResponseMessage.memberCount);
            }
            g.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (g.this.haN != null) {
                g.this.haN.a(guardClubMemberListHttpResponseMessage.bjd, guardClubMemberListHttpResponseMessage.bjg);
                if (!g.this.gcC || guardClubMemberListHttpResponseMessage.haF != 1) {
                    g.this.haN.cu(guardClubMemberListHttpResponseMessage.haM);
                } else {
                    g.this.haN.ct(guardClubMemberListHttpResponseMessage.haM);
                    g.this.haN.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    g.this.haN.bVL();
                } else {
                    g.this.haN.np(g.this.haH == 1);
                }
                g.this.haH++;
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void uz(int i);
    }

    public g(long j, boolean z, a aVar) {
        this.haO = j;
        this.gZt = z;
        this.gZr = aVar;
        bVS();
        MessageManager.getInstance().registerListener(this.haP);
    }

    public void k(com.baidu.tieba.ala.guardclub.l lVar) {
        this.haN = lVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bVO() {
        return this.hasMore;
    }

    public void bVP() {
        nq(true);
    }

    public void nq(boolean z) {
        this.gcC = z;
        if (z) {
            this.haH = 1;
        }
        bVU();
    }

    public void bVQ() {
        this.gcC = false;
        if (this.haN != null) {
            this.haN.bRy();
            bVU();
        }
    }

    private void bVU() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.haN != null) {
            this.haN.Sh();
            return;
        }
        h hVar = new h();
        hVar.setAnchorId(this.haO);
        hVar.setPn(this.haH);
        if (this.gZt) {
            hVar.setPs(20);
        } else {
            hVar.setPs(10);
        }
        hVar.setParams();
        MessageManager.getInstance().sendMessage(hVar);
    }

    private void bVS() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.haP != null) {
            MessageManager.getInstance().unRegisterListener(this.haP);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
