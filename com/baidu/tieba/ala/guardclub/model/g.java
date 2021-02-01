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
    private a gZd;
    private boolean gZf;
    private boolean gcx;
    private long haA;
    private boolean hasMore;
    private com.baidu.tieba.ala.guardclub.l haz;
    private int hat = 1;
    private HttpMessageListener haB = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (g.this.haz != null) {
                    g.this.haz.bOi();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (g.this.haz != null) {
                    g.this.haz.bOi();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && g.this.gZd != null) {
                g.this.gZd.uz(guardClubMemberListHttpResponseMessage.memberCount);
            }
            g.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (g.this.haz != null) {
                g.this.haz.a(guardClubMemberListHttpResponseMessage.bjd, guardClubMemberListHttpResponseMessage.bjg);
                if (!g.this.gcx || guardClubMemberListHttpResponseMessage.har != 1) {
                    g.this.haz.cu(guardClubMemberListHttpResponseMessage.hay);
                } else {
                    g.this.haz.ct(guardClubMemberListHttpResponseMessage.hay);
                    g.this.haz.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    g.this.haz.bVE();
                } else {
                    g.this.haz.np(g.this.hat == 1);
                }
                g.this.hat++;
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void uz(int i);
    }

    public g(long j, boolean z, a aVar) {
        this.haA = j;
        this.gZf = z;
        this.gZd = aVar;
        bVL();
        MessageManager.getInstance().registerListener(this.haB);
    }

    public void k(com.baidu.tieba.ala.guardclub.l lVar) {
        this.haz = lVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bVH() {
        return this.hasMore;
    }

    public void bVI() {
        nq(true);
    }

    public void nq(boolean z) {
        this.gcx = z;
        if (z) {
            this.hat = 1;
        }
        bVN();
    }

    public void bVJ() {
        this.gcx = false;
        if (this.haz != null) {
            this.haz.bRr();
            bVN();
        }
    }

    private void bVN() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.haz != null) {
            this.haz.Sh();
            return;
        }
        h hVar = new h();
        hVar.setAnchorId(this.haA);
        hVar.setPn(this.hat);
        if (this.gZf) {
            hVar.setPs(20);
        } else {
            hVar.setPs(10);
        }
        hVar.setParams();
        MessageManager.getInstance().sendMessage(hVar);
    }

    private void bVL() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.haB != null) {
            MessageManager.getInstance().unRegisterListener(this.haB);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
