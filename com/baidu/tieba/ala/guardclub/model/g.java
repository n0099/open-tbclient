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
    private boolean geO;
    private a haZ;
    private boolean hasMore;
    private boolean hbb;
    private com.baidu.tieba.ala.guardclub.l hcv;
    private long hcw;
    private int hcp = 1;
    private HttpMessageListener hcx = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (g.this.hcv != null) {
                    g.this.hcv.bRy();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (g.this.hcv != null) {
                    g.this.hcv.bRy();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && g.this.haZ != null) {
                g.this.haZ.vZ(guardClubMemberListHttpResponseMessage.memberCount);
            }
            g.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (g.this.hcv != null) {
                g.this.hcv.a(guardClubMemberListHttpResponseMessage.bkK, guardClubMemberListHttpResponseMessage.bkN);
                if (!g.this.geO || guardClubMemberListHttpResponseMessage.hcn != 1) {
                    g.this.hcv.cz(guardClubMemberListHttpResponseMessage.hcu);
                } else {
                    g.this.hcv.cy(guardClubMemberListHttpResponseMessage.hcu);
                    g.this.hcv.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    g.this.hcv.bYQ();
                } else {
                    g.this.hcv.no(g.this.hcp == 1);
                }
                g.this.hcp++;
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void vZ(int i);
    }

    public g(long j, boolean z, a aVar) {
        this.hcw = j;
        this.hbb = z;
        this.haZ = aVar;
        bYX();
        MessageManager.getInstance().registerListener(this.hcx);
    }

    public void k(com.baidu.tieba.ala.guardclub.l lVar) {
        this.hcv = lVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bYT() {
        return this.hasMore;
    }

    public void bYU() {
        np(true);
    }

    public void np(boolean z) {
        this.geO = z;
        if (z) {
            this.hcp = 1;
        }
        bYZ();
    }

    public void bYV() {
        this.geO = false;
        if (this.hcv != null) {
            this.hcv.bUE();
            bYZ();
        }
    }

    private void bYZ() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.hcv != null) {
            this.hcv.Us();
            return;
        }
        h hVar = new h();
        hVar.setAnchorId(this.hcw);
        hVar.setPn(this.hcp);
        if (this.hbb) {
            hVar.setPs(20);
        } else {
            hVar.setPs(10);
        }
        hVar.setParams();
        MessageManager.getInstance().sendMessage(hVar);
    }

    private void bYX() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.hcx != null) {
            MessageManager.getInstance().unRegisterListener(this.hcx);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
