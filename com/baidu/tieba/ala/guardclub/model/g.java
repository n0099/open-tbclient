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
    private boolean dTi;
    private a eFt;
    private boolean eFv;
    private com.baidu.tieba.ala.guardclub.k eGW;
    private long eGX;
    private boolean hasMore;
    private int eGQ = 1;
    private HttpMessageListener eGY = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (g.this.eGW != null) {
                    g.this.eGW.bbB();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (g.this.eGW != null) {
                    g.this.eGW.bbB();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && g.this.eFt != null) {
                g.this.eFt.pq(guardClubMemberListHttpResponseMessage.memberCount);
            }
            g.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (g.this.eGW != null) {
                g.this.eGW.a(guardClubMemberListHttpResponseMessage.aqa, guardClubMemberListHttpResponseMessage.aqd);
                if (!g.this.dTi || guardClubMemberListHttpResponseMessage.eGO != 1) {
                    g.this.eGW.bv(guardClubMemberListHttpResponseMessage.eGV);
                } else {
                    g.this.eGW.bu(guardClubMemberListHttpResponseMessage.eGV);
                    g.this.eGW.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    g.this.eGW.bfl();
                } else {
                    g.this.eGW.iD(g.this.eGQ == 1);
                }
                g.this.eGQ++;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void pq(int i);
    }

    public g(long j, boolean z, a aVar) {
        this.eGX = j;
        this.eFv = z;
        this.eFt = aVar;
        bfu();
        MessageManager.getInstance().registerListener(this.eGY);
    }

    public void j(com.baidu.tieba.ala.guardclub.k kVar) {
        this.eGW = kVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bfq() {
        return this.hasMore;
    }

    public void bfr() {
        iE(true);
    }

    public void iE(boolean z) {
        this.dTi = z;
        if (z) {
            this.eGQ = 1;
        }
        bfw();
    }

    public void bfs() {
        this.dTi = false;
        if (this.eGW != null) {
            this.eGW.bcu();
            bfw();
        }
    }

    private void bfw() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.eGW != null) {
            this.eGW.bfm();
            return;
        }
        h hVar = new h();
        hVar.D(this.eGX);
        hVar.setPn(this.eGQ);
        if (this.eFv) {
            hVar.setPs(20);
        } else {
            hVar.setPs(10);
        }
        hVar.setParams();
        MessageManager.getInstance().sendMessage(hVar);
    }

    private void bfu() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.eGY != null) {
            MessageManager.getInstance().unRegisterListener(this.eGY);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
