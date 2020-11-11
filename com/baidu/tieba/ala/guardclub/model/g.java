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
    private boolean fNU;
    private a gGw;
    private boolean gGy;
    private com.baidu.tieba.ala.guardclub.k gHS;
    private long gHT;
    private boolean hasMore;
    private int gHM = 1;
    private HttpMessageListener gHU = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (g.this.gHS != null) {
                    g.this.gHS.bLV();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (g.this.gHS != null) {
                    g.this.gHS.bLV();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && g.this.gGw != null) {
                g.this.gGw.uJ(guardClubMemberListHttpResponseMessage.memberCount);
            }
            g.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (g.this.gHS != null) {
                g.this.gHS.a(guardClubMemberListHttpResponseMessage.bgC, guardClubMemberListHttpResponseMessage.bgF);
                if (!g.this.fNU || guardClubMemberListHttpResponseMessage.gHK != 1) {
                    g.this.gHS.co(guardClubMemberListHttpResponseMessage.gHR);
                } else {
                    g.this.gHS.cn(guardClubMemberListHttpResponseMessage.gHR);
                    g.this.gHS.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    g.this.gHS.bTh();
                } else {
                    g.this.gHS.ms(g.this.gHM == 1);
                }
                g.this.gHM++;
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void uJ(int i);
    }

    public g(long j, boolean z, a aVar) {
        this.gHT = j;
        this.gGy = z;
        this.gGw = aVar;
        bTo();
        MessageManager.getInstance().registerListener(this.gHU);
    }

    public void k(com.baidu.tieba.ala.guardclub.k kVar) {
        this.gHS = kVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bTk() {
        return this.hasMore;
    }

    public void bTl() {
        mt(true);
    }

    public void mt(boolean z) {
        this.fNU = z;
        if (z) {
            this.gHM = 1;
        }
        bTq();
    }

    public void bTm() {
        this.fNU = false;
        if (this.gHS != null) {
            this.gHS.bOX();
            bTq();
        }
    }

    private void bTq() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.gHS != null) {
            this.gHS.Ry();
            return;
        }
        h hVar = new h();
        hVar.setAnchorId(this.gHT);
        hVar.setPn(this.gHM);
        if (this.gGy) {
            hVar.setPs(20);
        } else {
            hVar.setPs(10);
        }
        hVar.setParams();
        MessageManager.getInstance().sendMessage(hVar);
    }

    private void bTo() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.gHU != null) {
            MessageManager.getInstance().unRegisterListener(this.gHU);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
