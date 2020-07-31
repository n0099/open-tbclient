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
    private boolean eZg;
    private a fOY;
    private boolean fPa;
    private com.baidu.tieba.ala.guardclub.k fQw;
    private long fQx;
    private boolean hasMore;
    private int fQq = 1;
    private HttpMessageListener fQy = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (g.this.fQw != null) {
                    g.this.fQw.buK();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (g.this.fQw != null) {
                    g.this.fQw.buK();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && g.this.fOY != null) {
                g.this.fOY.re(guardClubMemberListHttpResponseMessage.memberCount);
            }
            g.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (g.this.fQw != null) {
                g.this.fQw.a(guardClubMemberListHttpResponseMessage.aSI, guardClubMemberListHttpResponseMessage.aSL);
                if (!g.this.eZg || guardClubMemberListHttpResponseMessage.fQo != 1) {
                    g.this.fQw.bO(guardClubMemberListHttpResponseMessage.fQv);
                } else {
                    g.this.fQw.bN(guardClubMemberListHttpResponseMessage.fQv);
                    g.this.fQw.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    g.this.fQw.bAM();
                } else {
                    g.this.fQw.kR(g.this.fQq == 1);
                }
                g.this.fQq++;
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void re(int i);
    }

    public g(long j, boolean z, a aVar) {
        this.fQx = j;
        this.fPa = z;
        this.fOY = aVar;
        bAV();
        MessageManager.getInstance().registerListener(this.fQy);
    }

    public void k(com.baidu.tieba.ala.guardclub.k kVar) {
        this.fQw = kVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bAR() {
        return this.hasMore;
    }

    public void bAS() {
        kS(true);
    }

    public void kS(boolean z) {
        this.eZg = z;
        if (z) {
            this.fQq = 1;
        }
        bAX();
    }

    public void bAT() {
        this.eZg = false;
        if (this.fQw != null) {
            this.fQw.bwT();
            bAX();
        }
    }

    private void bAX() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.fQw != null) {
            this.fQw.bAN();
            return;
        }
        h hVar = new h();
        hVar.af(this.fQx);
        hVar.setPn(this.fQq);
        if (this.fPa) {
            hVar.setPs(20);
        } else {
            hVar.setPs(10);
        }
        hVar.setParams();
        MessageManager.getInstance().sendMessage(hVar);
    }

    private void bAV() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.fQy != null) {
            MessageManager.getInstance().unRegisterListener(this.fQy);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
