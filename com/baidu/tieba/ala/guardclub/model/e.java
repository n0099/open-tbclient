package com.baidu.tieba.ala.guardclub.model;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.guardclub.GuardClubJoinListActivity;
/* loaded from: classes10.dex */
public class e extends BdBaseModel<GuardClubJoinListActivity> {
    private boolean gec;
    private a haR;
    private boolean hasMore;
    private com.baidu.tieba.ala.guardclub.view.d hcp;
    private b hcr;
    private int hcq = 1;
    private HttpMessageListener hcs = new HttpMessageListener(1021139) { // from class: com.baidu.tieba.ala.guardclub.model.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubJoinListHttpResponseMessage)) {
                if (e.this.hcp != null) {
                    e.this.hcp.bOv();
                    return;
                }
                return;
            }
            GuardClubJoinListHttpResponseMessage guardClubJoinListHttpResponseMessage = (GuardClubJoinListHttpResponseMessage) httpResponsedMessage;
            if (guardClubJoinListHttpResponseMessage.getError() != 0) {
                if (e.this.hcp != null) {
                    e.this.hcp.bOv();
                    return;
                }
                return;
            }
            e.this.hasMore = guardClubJoinListHttpResponseMessage.hasMore;
            if (e.this.hcp != null) {
                if (e.this.gec) {
                    e.this.hcp.cr(guardClubJoinListHttpResponseMessage.hcn);
                    e.this.hcp.completePullRefresh();
                } else {
                    e.this.hcp.cs(guardClubJoinListHttpResponseMessage.hcn);
                }
                if (guardClubJoinListHttpResponseMessage.hasMore) {
                    e.this.hcp.bVR();
                } else if (!e.this.gec) {
                    e.this.hcp.np(e.this.hcq == 1);
                }
                e.this.hcq++;
            }
        }
    };
    private HttpMessageListener hct = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.guardclub.model.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubQuitHttpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == e.this.unique_id && httpResponsedMessage.getError() == 0 && e.this.hcr != null) {
                e.this.hcr.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
    }

    /* loaded from: classes10.dex */
    public interface b {
        void b(int i, String str, Object obj);
    }

    public e(BdUniqueId bdUniqueId, a aVar) {
        this.unique_id = bdUniqueId;
        this.haR = aVar;
        bVY();
        bVZ();
        MessageManager.getInstance().registerListener(this.hcs);
        MessageManager.getInstance().registerListener(this.hct);
    }

    public void a(com.baidu.tieba.ala.guardclub.view.d dVar) {
        this.hcp = dVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bVU() {
        return this.hasMore;
    }

    public void bVV() {
        nq(true);
    }

    public void nq(boolean z) {
        this.gec = z;
        if (z) {
            this.hcq = 1;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            bVX();
        } else if (this.hcp != null) {
            this.hcp.bOv();
        }
    }

    public void bVW() {
        this.gec = false;
        if (this.hcp != null) {
            this.hcp.bRE();
            bVX();
        }
    }

    private void bVX() {
        f fVar = new f();
        fVar.setPn(this.hcq);
        fVar.setPs(20);
        fVar.setParams();
        fVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(fVar);
    }

    public void a(String str, b bVar) {
        j jVar = new j();
        jVar.He(str);
        jVar.setParams();
        jVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(jVar);
        this.hcr = bVar;
    }

    private void bVY() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021139, TbConfig.SERVER_HOST + "liveserver/guardClub/joinlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bVZ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/guardClub/quit");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GuardClubQuitHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.hcs != null) {
            MessageManager.getInstance().unRegisterListener(this.hcs);
        }
        if (this.hct != null) {
            MessageManager.getInstance().unRegisterListener(this.hcs);
        }
        MessageManager.getInstance().unRegisterTask(1021139);
    }
}
