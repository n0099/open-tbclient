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
    private boolean etP;
    private a fkC;
    private boolean fkE;
    private com.baidu.tieba.ala.guardclub.k fmb;
    private long fmc;
    private boolean hasMore;
    private int flV = 1;
    private HttpMessageListener fmd = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (g.this.fmb != null) {
                    g.this.fmb.bjH();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (g.this.fmb != null) {
                    g.this.fmb.bjH();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && g.this.fkC != null) {
                g.this.fkC.pM(guardClubMemberListHttpResponseMessage.memberCount);
            }
            g.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (g.this.fmb != null) {
                g.this.fmb.a(guardClubMemberListHttpResponseMessage.aJa, guardClubMemberListHttpResponseMessage.aJd);
                if (!g.this.etP || guardClubMemberListHttpResponseMessage.flT != 1) {
                    g.this.fmb.bE(guardClubMemberListHttpResponseMessage.fma);
                } else {
                    g.this.fmb.bD(guardClubMemberListHttpResponseMessage.fma);
                    g.this.fmb.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    g.this.fmb.boG();
                } else {
                    g.this.fmb.jG(g.this.flV == 1);
                }
                g.this.flV++;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void pM(int i);
    }

    public g(long j, boolean z, a aVar) {
        this.fmc = j;
        this.fkE = z;
        this.fkC = aVar;
        boP();
        MessageManager.getInstance().registerListener(this.fmd);
    }

    public void j(com.baidu.tieba.ala.guardclub.k kVar) {
        this.fmb = kVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean boL() {
        return this.hasMore;
    }

    public void boM() {
        jH(true);
    }

    public void jH(boolean z) {
        this.etP = z;
        if (z) {
            this.flV = 1;
        }
        boR();
    }

    public void boN() {
        this.etP = false;
        if (this.fmb != null) {
            this.fmb.blo();
            boR();
        }
    }

    private void boR() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.fmb != null) {
            this.fmb.boH();
            return;
        }
        h hVar = new h();
        hVar.ab(this.fmc);
        hVar.setPn(this.flV);
        if (this.fkE) {
            hVar.setPs(20);
        } else {
            hVar.setPs(10);
        }
        hVar.setParams();
        MessageManager.getInstance().sendMessage(hVar);
    }

    private void boP() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.fmd != null) {
            MessageManager.getInstance().unRegisterListener(this.fmd);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
