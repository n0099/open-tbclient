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
    private boolean dTh;
    private a eFs;
    private boolean eFu;
    private com.baidu.tieba.ala.guardclub.k eGV;
    private long eGW;
    private boolean hasMore;
    private int eGP = 1;
    private HttpMessageListener eGX = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (g.this.eGV != null) {
                    g.this.eGV.bbz();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (g.this.eGV != null) {
                    g.this.eGV.bbz();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && g.this.eFs != null) {
                g.this.eFs.pq(guardClubMemberListHttpResponseMessage.memberCount);
            }
            g.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (g.this.eGV != null) {
                g.this.eGV.a(guardClubMemberListHttpResponseMessage.aqa, guardClubMemberListHttpResponseMessage.aqd);
                if (!g.this.dTh || guardClubMemberListHttpResponseMessage.eGN != 1) {
                    g.this.eGV.bv(guardClubMemberListHttpResponseMessage.eGU);
                } else {
                    g.this.eGV.bu(guardClubMemberListHttpResponseMessage.eGU);
                    g.this.eGV.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    g.this.eGV.bfj();
                } else {
                    g.this.eGV.iD(g.this.eGP == 1);
                }
                g.this.eGP++;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void pq(int i);
    }

    public g(long j, boolean z, a aVar) {
        this.eGW = j;
        this.eFu = z;
        this.eFs = aVar;
        bfs();
        MessageManager.getInstance().registerListener(this.eGX);
    }

    public void j(com.baidu.tieba.ala.guardclub.k kVar) {
        this.eGV = kVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bfo() {
        return this.hasMore;
    }

    public void bfp() {
        iE(true);
    }

    public void iE(boolean z) {
        this.dTh = z;
        if (z) {
            this.eGP = 1;
        }
        bfu();
    }

    public void bfq() {
        this.dTh = false;
        if (this.eGV != null) {
            this.eGV.bcs();
            bfu();
        }
    }

    private void bfu() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.eGV != null) {
            this.eGV.bfk();
            return;
        }
        h hVar = new h();
        hVar.D(this.eGW);
        hVar.setPn(this.eGP);
        if (this.eFu) {
            hVar.setPs(20);
        } else {
            hVar.setPs(10);
        }
        hVar.setParams();
        MessageManager.getInstance().sendMessage(hVar);
    }

    private void bfs() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.eGX != null) {
            MessageManager.getInstance().unRegisterListener(this.eGX);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
