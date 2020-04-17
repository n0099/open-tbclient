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
    private boolean etK;
    private a fkx;
    private boolean fkz;
    private com.baidu.tieba.ala.guardclub.k flW;
    private long flX;
    private boolean hasMore;
    private int flQ = 1;
    private HttpMessageListener flY = new HttpMessageListener(1021138) { // from class: com.baidu.tieba.ala.guardclub.model.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubMemberListHttpResponseMessage)) {
                if (g.this.flW != null) {
                    g.this.flW.bjJ();
                    return;
                }
                return;
            }
            GuardClubMemberListHttpResponseMessage guardClubMemberListHttpResponseMessage = (GuardClubMemberListHttpResponseMessage) httpResponsedMessage;
            if (guardClubMemberListHttpResponseMessage.getError() != 0) {
                if (g.this.flW != null) {
                    g.this.flW.bjJ();
                    return;
                }
                return;
            }
            if (guardClubMemberListHttpResponseMessage.memberCount >= 0 && g.this.fkx != null) {
                g.this.fkx.pM(guardClubMemberListHttpResponseMessage.memberCount);
            }
            g.this.hasMore = guardClubMemberListHttpResponseMessage.hasMore;
            if (g.this.flW != null) {
                g.this.flW.a(guardClubMemberListHttpResponseMessage.aIU, guardClubMemberListHttpResponseMessage.aIX);
                if (!g.this.etK || guardClubMemberListHttpResponseMessage.flO != 1) {
                    g.this.flW.bE(guardClubMemberListHttpResponseMessage.flV);
                } else {
                    g.this.flW.bD(guardClubMemberListHttpResponseMessage.flV);
                    g.this.flW.completePullRefresh();
                }
                if (guardClubMemberListHttpResponseMessage.hasMore) {
                    g.this.flW.boI();
                } else {
                    g.this.flW.jG(g.this.flQ == 1);
                }
                g.this.flQ++;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void pM(int i);
    }

    public g(long j, boolean z, a aVar) {
        this.flX = j;
        this.fkz = z;
        this.fkx = aVar;
        boR();
        MessageManager.getInstance().registerListener(this.flY);
    }

    public void j(com.baidu.tieba.ala.guardclub.k kVar) {
        this.flW = kVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean boN() {
        return this.hasMore;
    }

    public void boO() {
        jH(true);
    }

    public void jH(boolean z) {
        this.etK = z;
        if (z) {
            this.flQ = 1;
        }
        boT();
    }

    public void boP() {
        this.etK = false;
        if (this.flW != null) {
            this.flW.blq();
            boT();
        }
    }

    private void boT() {
        if (!BdNetTypeUtil.isNetWorkAvailable() && this.flW != null) {
            this.flW.boJ();
            return;
        }
        h hVar = new h();
        hVar.ab(this.flX);
        hVar.setPn(this.flQ);
        if (this.fkz) {
            hVar.setPs(20);
        } else {
            hVar.setPs(10);
        }
        hVar.setParams();
        MessageManager.getInstance().sendMessage(hVar);
    }

    private void boR() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021138, TbConfig.SERVER_HOST + "liveserver/guardClub/memberlist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubMemberListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.flY != null) {
            MessageManager.getInstance().unRegisterListener(this.flY);
        }
        MessageManager.getInstance().unRegisterTask(1021138);
    }
}
