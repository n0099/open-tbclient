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
/* loaded from: classes7.dex */
public class g extends BdBaseModel<GuardClubMemberListActivity> {
    private boolean fkC;
    private a gbb;
    private boolean gbd;
    private com.baidu.tieba.ala.guardclub.k gcy;
    private long gcz;
    private boolean hasMore;
    private int gcs = 1;
    private HttpMessageListener gcA = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (g.this.gcy != null) {
                    g.this.gcy.bDG();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (g.this.gcy != null) {
                    g.this.gcy.bDG();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && g.this.gbb != null) {
                g.this.gbb.tq(guardClubMemberListHttpResponseMessage.memberCount);
            }
            g.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (g.this.gcy != null) {
                g.this.gcy.a(guardClubMemberListHttpResponseMessage.aXY, guardClubMemberListHttpResponseMessage.aYb);
                if (!g.this.fkC || guardClubMemberListHttpResponseMessage.gcq != 1) {
                    g.this.gcy.bP(guardClubMemberListHttpResponseMessage.gcx);
                } else {
                    g.this.gcy.bO(guardClubMemberListHttpResponseMessage.gcx);
                    g.this.gcy.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    g.this.gcy.bKi();
                } else {
                    g.this.gcy.lt(g.this.gcs == 1);
                }
                g.this.gcs++;
            }
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void tq(int i);
    }

    public g(long j, boolean z, a aVar) {
        this.gcz = j;
        this.gbd = z;
        this.gbb = aVar;
        bKq();
        MessageManager.getInstance().registerListener(this.gcA);
    }

    public void k(com.baidu.tieba.ala.guardclub.k kVar) {
        this.gcy = kVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bKm() {
        return this.hasMore;
    }

    public void bKn() {
        lu(true);
    }

    public void lu(boolean z) {
        this.fkC = z;
        if (z) {
            this.gcs = 1;
        }
        bKs();
    }

    public void bKo() {
        this.fkC = false;
        if (this.gcy != null) {
            this.gcy.bFT();
            bKs();
        }
    }

    private void bKs() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.gcy != null) {
            this.gcy.bKj();
            return;
        }
        h hVar = new h();
        hVar.ag(this.gcz);
        hVar.setPn(this.gcs);
        if (this.gbd) {
            hVar.setPs(20);
        } else {
            hVar.setPs(10);
        }
        hVar.setParams();
        MessageManager.getInstance().sendMessage(hVar);
    }

    private void bKq() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.gcA != null) {
            MessageManager.getInstance().unRegisterListener(this.gcA);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
