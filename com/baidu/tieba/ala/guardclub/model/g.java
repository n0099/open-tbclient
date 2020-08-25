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
    private boolean fky;
    private a gaX;
    private boolean gaZ;
    private com.baidu.tieba.ala.guardclub.k gcu;
    private long gcv;
    private boolean hasMore;
    private int gco = 1;
    private HttpMessageListener gcw = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (g.this.gcu != null) {
                    g.this.gcu.bDF();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (g.this.gcu != null) {
                    g.this.gcu.bDF();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && g.this.gaX != null) {
                g.this.gaX.tq(guardClubMemberListHttpResponseMessage.memberCount);
            }
            g.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (g.this.gcu != null) {
                g.this.gcu.a(guardClubMemberListHttpResponseMessage.aXW, guardClubMemberListHttpResponseMessage.aXZ);
                if (!g.this.fky || guardClubMemberListHttpResponseMessage.gcm != 1) {
                    g.this.gcu.bP(guardClubMemberListHttpResponseMessage.gct);
                } else {
                    g.this.gcu.bO(guardClubMemberListHttpResponseMessage.gct);
                    g.this.gcu.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    g.this.gcu.bKh();
                } else {
                    g.this.gcu.lr(g.this.gco == 1);
                }
                g.this.gco++;
            }
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void tq(int i);
    }

    public g(long j, boolean z, a aVar) {
        this.gcv = j;
        this.gaZ = z;
        this.gaX = aVar;
        bKp();
        MessageManager.getInstance().registerListener(this.gcw);
    }

    public void k(com.baidu.tieba.ala.guardclub.k kVar) {
        this.gcu = kVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bKl() {
        return this.hasMore;
    }

    public void bKm() {
        ls(true);
    }

    public void ls(boolean z) {
        this.fky = z;
        if (z) {
            this.gco = 1;
        }
        bKr();
    }

    public void bKn() {
        this.fky = false;
        if (this.gcu != null) {
            this.gcu.bFS();
            bKr();
        }
    }

    private void bKr() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.gcu != null) {
            this.gcu.bKi();
            return;
        }
        h hVar = new h();
        hVar.ag(this.gcv);
        hVar.setPn(this.gco);
        if (this.gaZ) {
            hVar.setPs(20);
        } else {
            hVar.setPs(10);
        }
        hVar.setParams();
        MessageManager.getInstance().sendMessage(hVar);
    }

    private void bKp() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.gcw != null) {
            MessageManager.getInstance().unRegisterListener(this.gcw);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
