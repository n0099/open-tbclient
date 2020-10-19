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
    private boolean fzJ;
    private a gqD;
    private boolean gqF;
    private com.baidu.tieba.ala.guardclub.k gsa;
    private long gsb;
    private boolean hasMore;
    private int grU = 1;
    private HttpMessageListener gsc = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (g.this.gsa != null) {
                    g.this.gsa.bHF();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (g.this.gsa != null) {
                    g.this.gsa.bHF();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && g.this.gqD != null) {
                g.this.gqD.uh(guardClubMemberListHttpResponseMessage.memberCount);
            }
            g.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (g.this.gsa != null) {
                g.this.gsa.a(guardClubMemberListHttpResponseMessage.bdQ, guardClubMemberListHttpResponseMessage.bdT);
                if (!g.this.fzJ || guardClubMemberListHttpResponseMessage.grS != 1) {
                    g.this.gsa.bX(guardClubMemberListHttpResponseMessage.grZ);
                } else {
                    g.this.gsa.bW(guardClubMemberListHttpResponseMessage.grZ);
                    g.this.gsa.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    g.this.gsa.bOc();
                } else {
                    g.this.gsa.lT(g.this.grU == 1);
                }
                g.this.grU++;
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void uh(int i);
    }

    public g(long j, boolean z, a aVar) {
        this.gsb = j;
        this.gqF = z;
        this.gqD = aVar;
        bOk();
        MessageManager.getInstance().registerListener(this.gsc);
    }

    public void k(com.baidu.tieba.ala.guardclub.k kVar) {
        this.gsa = kVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bOg() {
        return this.hasMore;
    }

    public void bOh() {
        lU(true);
    }

    public void lU(boolean z) {
        this.fzJ = z;
        if (z) {
            this.grU = 1;
        }
        bOm();
    }

    public void bOi() {
        this.fzJ = false;
        if (this.gsa != null) {
            this.gsa.bJV();
            bOm();
        }
    }

    private void bOm() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.gsa != null) {
            this.gsa.bOd();
            return;
        }
        h hVar = new h();
        hVar.setAnchorId(this.gsb);
        hVar.setPn(this.grU);
        if (this.gqF) {
            hVar.setPs(20);
        } else {
            hVar.setPs(10);
        }
        hVar.setParams();
        MessageManager.getInstance().sendMessage(hVar);
    }

    private void bOk() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.gsc != null) {
            MessageManager.getInstance().unRegisterListener(this.gsc);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
