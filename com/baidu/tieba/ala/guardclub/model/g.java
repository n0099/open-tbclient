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
/* loaded from: classes3.dex */
public class g extends BdBaseModel<GuardClubMemberListActivity> {
    private boolean dTv;
    private a eFG;
    private boolean eFI;
    private com.baidu.tieba.ala.guardclub.k eHj;
    private long eHk;
    private boolean hasMore;
    private int eHd = 1;
    private HttpMessageListener eHl = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (g.this.eHj != null) {
                    g.this.eHj.bbC();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (g.this.eHj != null) {
                    g.this.eHj.bbC();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && g.this.eFG != null) {
                g.this.eFG.pq(guardClubMemberListHttpResponseMessage.memberCount);
            }
            g.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (g.this.eHj != null) {
                g.this.eHj.a(guardClubMemberListHttpResponseMessage.aqb, guardClubMemberListHttpResponseMessage.aqe);
                if (!g.this.dTv || guardClubMemberListHttpResponseMessage.eHb != 1) {
                    g.this.eHj.bv(guardClubMemberListHttpResponseMessage.eHi);
                } else {
                    g.this.eHj.bu(guardClubMemberListHttpResponseMessage.eHi);
                    g.this.eHj.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    g.this.eHj.bfm();
                } else {
                    g.this.eHj.iD(g.this.eHd == 1);
                }
                g.this.eHd++;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void pq(int i);
    }

    public g(long j, boolean z, a aVar) {
        this.eHk = j;
        this.eFI = z;
        this.eFG = aVar;
        bfv();
        MessageManager.getInstance().registerListener(this.eHl);
    }

    public void j(com.baidu.tieba.ala.guardclub.k kVar) {
        this.eHj = kVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bfr() {
        return this.hasMore;
    }

    public void bfs() {
        iE(true);
    }

    public void iE(boolean z) {
        this.dTv = z;
        if (z) {
            this.eHd = 1;
        }
        bfx();
    }

    public void bft() {
        this.dTv = false;
        if (this.eHj != null) {
            this.eHj.bcv();
            bfx();
        }
    }

    private void bfx() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.eHj != null) {
            this.eHj.bfn();
            return;
        }
        h hVar = new h();
        hVar.D(this.eHk);
        hVar.setPn(this.eHd);
        if (this.eFI) {
            hVar.setPs(20);
        } else {
            hVar.setPs(10);
        }
        hVar.setParams();
        MessageManager.getInstance().sendMessage(hVar);
    }

    private void bfv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.eHl != null) {
            MessageManager.getInstance().unRegisterListener(this.eHl);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
