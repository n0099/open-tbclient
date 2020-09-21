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
    private boolean fnv;
    private a gen;
    private boolean geq;
    private com.baidu.tieba.ala.guardclub.k gfL;
    private long gfM;
    private boolean hasMore;
    private int gfF = 1;
    private HttpMessageListener gfN = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (g.this.gfL != null) {
                    g.this.gfL.bET();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (g.this.gfL != null) {
                    g.this.gfL.bET();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && g.this.gen != null) {
                g.this.gen.tJ(guardClubMemberListHttpResponseMessage.memberCount);
            }
            g.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (g.this.gfL != null) {
                g.this.gfL.a(guardClubMemberListHttpResponseMessage.baw, guardClubMemberListHttpResponseMessage.baz);
                if (!g.this.fnv || guardClubMemberListHttpResponseMessage.gfD != 1) {
                    g.this.gfL.bU(guardClubMemberListHttpResponseMessage.gfK);
                } else {
                    g.this.gfL.bT(guardClubMemberListHttpResponseMessage.gfK);
                    g.this.gfL.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    g.this.gfL.bLs();
                } else {
                    g.this.gfL.lv(g.this.gfF == 1);
                }
                g.this.gfF++;
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void tJ(int i);
    }

    public g(long j, boolean z, a aVar) {
        this.gfM = j;
        this.geq = z;
        this.gen = aVar;
        bLA();
        MessageManager.getInstance().registerListener(this.gfN);
    }

    public void k(com.baidu.tieba.ala.guardclub.k kVar) {
        this.gfL = kVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bLw() {
        return this.hasMore;
    }

    public void bLx() {
        lw(true);
    }

    public void lw(boolean z) {
        this.fnv = z;
        if (z) {
            this.gfF = 1;
        }
        bLC();
    }

    public void bLy() {
        this.fnv = false;
        if (this.gfL != null) {
            this.gfL.bHj();
            bLC();
        }
    }

    private void bLC() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.gfL != null) {
            this.gfL.bLt();
            return;
        }
        h hVar = new h();
        hVar.af(this.gfM);
        hVar.setPn(this.gfF);
        if (this.geq) {
            hVar.setPs(20);
        } else {
            hVar.setPs(10);
        }
        hVar.setParams();
        MessageManager.getInstance().sendMessage(hVar);
    }

    private void bLA() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.gfN != null) {
            MessageManager.getInstance().unRegisterListener(this.gfN);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
