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
/* loaded from: classes11.dex */
public class e extends BdBaseModel<GuardClubJoinListActivity> {
    private a gYU;
    private boolean gcx;
    private com.baidu.tieba.ala.guardclub.view.d has;
    private boolean hasMore;
    private b hau;
    private int hat = 1;
    private HttpMessageListener hav = new HttpMessageListener(1021139) { // from class: com.baidu.tieba.ala.guardclub.model.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubJoinListHttpResponseMessage)) {
                if (e.this.has != null) {
                    e.this.has.bOi();
                    return;
                }
                return;
            }
            GuardClubJoinListHttpResponseMessage guardClubJoinListHttpResponseMessage = (GuardClubJoinListHttpResponseMessage) httpResponsedMessage;
            if (guardClubJoinListHttpResponseMessage.getError() != 0) {
                if (e.this.has != null) {
                    e.this.has.bOi();
                    return;
                }
                return;
            }
            e.this.hasMore = guardClubJoinListHttpResponseMessage.hasMore;
            if (e.this.has != null) {
                if (e.this.gcx) {
                    e.this.has.cr(guardClubJoinListHttpResponseMessage.haq);
                    e.this.has.completePullRefresh();
                } else {
                    e.this.has.cs(guardClubJoinListHttpResponseMessage.haq);
                }
                if (guardClubJoinListHttpResponseMessage.hasMore) {
                    e.this.has.bVE();
                } else if (!e.this.gcx) {
                    e.this.has.np(e.this.hat == 1);
                }
                e.this.hat++;
            }
        }
    };
    private HttpMessageListener haw = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.guardclub.model.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubQuitHttpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == e.this.unique_id && httpResponsedMessage.getError() == 0 && e.this.hau != null) {
                e.this.hau.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
    }

    /* loaded from: classes11.dex */
    public interface b {
        void b(int i, String str, Object obj);
    }

    public e(BdUniqueId bdUniqueId, a aVar) {
        this.unique_id = bdUniqueId;
        this.gYU = aVar;
        bVL();
        bVM();
        MessageManager.getInstance().registerListener(this.hav);
        MessageManager.getInstance().registerListener(this.haw);
    }

    public void a(com.baidu.tieba.ala.guardclub.view.d dVar) {
        this.has = dVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bVH() {
        return this.hasMore;
    }

    public void bVI() {
        nq(true);
    }

    public void nq(boolean z) {
        this.gcx = z;
        if (z) {
            this.hat = 1;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            bVK();
        } else if (this.has != null) {
            this.has.bOi();
        }
    }

    public void bVJ() {
        this.gcx = false;
        if (this.has != null) {
            this.has.bRr();
            bVK();
        }
    }

    private void bVK() {
        f fVar = new f();
        fVar.setPn(this.hat);
        fVar.setPs(20);
        fVar.setParams();
        fVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(fVar);
    }

    public void a(String str, b bVar) {
        j jVar = new j();
        jVar.GU(str);
        jVar.setParams();
        jVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(jVar);
        this.hau = bVar;
    }

    private void bVL() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021139, TbConfig.SERVER_HOST + "liveserver/guardClub/joinlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bVM() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/guardClub/quit");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GuardClubQuitHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.hav != null) {
            MessageManager.getInstance().unRegisterListener(this.hav);
        }
        if (this.haw != null) {
            MessageManager.getInstance().unRegisterListener(this.hav);
        }
        MessageManager.getInstance().unRegisterTask(1021139);
    }
}
