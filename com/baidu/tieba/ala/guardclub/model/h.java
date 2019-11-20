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
/* loaded from: classes6.dex */
public class h extends BdBaseModel<GuardClubJoinListActivity> {
    private a dLx;
    private com.baidu.tieba.ala.guardclub.view.b dNI;
    private b dNK;
    private boolean daZ;
    private boolean hasMore;
    private int dNJ = 1;
    private HttpMessageListener dNL = new HttpMessageListener(1021139) { // from class: com.baidu.tieba.ala.guardclub.model.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubJoinListHttpResponseMessage)) {
                if (h.this.dNI != null) {
                    h.this.dNI.aLr();
                    return;
                }
                return;
            }
            GuardClubJoinListHttpResponseMessage guardClubJoinListHttpResponseMessage = (GuardClubJoinListHttpResponseMessage) httpResponsedMessage;
            if (guardClubJoinListHttpResponseMessage.getError() != 0) {
                if (h.this.dNI != null) {
                    h.this.dNI.aLr();
                    return;
                }
                return;
            }
            h.this.hasMore = guardClubJoinListHttpResponseMessage.hasMore;
            if (h.this.dNI != null) {
                if (h.this.daZ) {
                    h.this.dNI.bt(guardClubJoinListHttpResponseMessage.dNG);
                    h.this.dNI.completePullRefresh();
                } else {
                    h.this.dNI.bu(guardClubJoinListHttpResponseMessage.dNG);
                }
                if (guardClubJoinListHttpResponseMessage.hasMore) {
                    h.this.dNI.aLp();
                } else if (!h.this.daZ) {
                    h.this.dNI.hf(h.this.dNJ == 1);
                }
                h.this.dNJ++;
            }
        }
    };
    private HttpMessageListener dNM = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.guardclub.model.h.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubQuitHttpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == h.this.unique_id && httpResponsedMessage.getError() == 0 && h.this.dNK != null) {
                h.this.dNK.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
    }

    /* loaded from: classes6.dex */
    public interface b {
        void b(int i, String str, Object obj);
    }

    public h(BdUniqueId bdUniqueId, a aVar) {
        this.unique_id = bdUniqueId;
        this.dLx = aVar;
        aLG();
        aLH();
        MessageManager.getInstance().registerListener(this.dNL);
        MessageManager.getInstance().registerListener(this.dNM);
    }

    public void a(com.baidu.tieba.ala.guardclub.view.b bVar) {
        this.dNI = bVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean aLC() {
        return this.hasMore;
    }

    public void aLD() {
        hg(true);
    }

    public void hg(boolean z) {
        this.daZ = z;
        if (z) {
            this.dNJ = 1;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            aLF();
        } else if (this.dNI != null) {
            this.dNI.aLr();
        }
    }

    public void aLE() {
        this.daZ = false;
        if (this.dNI != null) {
            this.dNI.aJj();
            aLF();
        }
    }

    private void aLF() {
        i iVar = new i();
        iVar.setPn(this.dNJ);
        iVar.setPs(20);
        iVar.setParams();
        iVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(iVar);
    }

    public void a(String str, b bVar) {
        o oVar = new o();
        oVar.to(str);
        oVar.setParams();
        oVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(oVar);
        this.dNK = bVar;
    }

    private void aLG() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021139, TbConfig.SERVER_HOST + "liveserver/guardClub/joinlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void aLH() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/guardClub/quit");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GuardClubQuitHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.dNL != null) {
            MessageManager.getInstance().unRegisterListener(this.dNL);
        }
        if (this.dNM != null) {
            MessageManager.getInstance().unRegisterListener(this.dNL);
        }
        MessageManager.getInstance().unRegisterTask(1021139);
    }
}
