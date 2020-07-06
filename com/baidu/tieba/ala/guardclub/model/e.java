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
/* loaded from: classes3.dex */
public class e extends BdBaseModel<GuardClubJoinListActivity> {
    private boolean eSL;
    private a fJt;
    private com.baidu.tieba.ala.guardclub.view.d fKV;
    private b fKX;
    private boolean hasMore;
    private int fKW = 1;
    private HttpMessageListener fKY = new HttpMessageListener(1021139) { // from class: com.baidu.tieba.ala.guardclub.model.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubJoinListHttpResponseMessage)) {
                if (e.this.fKV != null) {
                    e.this.fKV.brE();
                    return;
                }
                return;
            }
            GuardClubJoinListHttpResponseMessage guardClubJoinListHttpResponseMessage = (GuardClubJoinListHttpResponseMessage) httpResponsedMessage;
            if (guardClubJoinListHttpResponseMessage.getError() != 0) {
                if (e.this.fKV != null) {
                    e.this.fKV.brE();
                    return;
                }
                return;
            }
            e.this.hasMore = guardClubJoinListHttpResponseMessage.hasMore;
            if (e.this.fKV != null) {
                if (e.this.eSL) {
                    e.this.fKV.bH(guardClubJoinListHttpResponseMessage.fKT);
                    e.this.fKV.completePullRefresh();
                } else {
                    e.this.fKV.bI(guardClubJoinListHttpResponseMessage.fKT);
                }
                if (guardClubJoinListHttpResponseMessage.hasMore) {
                    e.this.fKV.bxw();
                } else if (!e.this.eSL) {
                    e.this.fKV.kn(e.this.fKW == 1);
                }
                e.this.fKW++;
            }
        }
    };
    private HttpMessageListener fKZ = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.guardclub.model.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubQuitHttpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == e.this.unique_id && httpResponsedMessage.getError() == 0 && e.this.fKX != null) {
                e.this.fKX.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
    }

    /* loaded from: classes3.dex */
    public interface b {
        void b(int i, String str, Object obj);
    }

    public e(BdUniqueId bdUniqueId, a aVar) {
        this.unique_id = bdUniqueId;
        this.fJt = aVar;
        bxF();
        bxG();
        MessageManager.getInstance().registerListener(this.fKY);
        MessageManager.getInstance().registerListener(this.fKZ);
    }

    public void a(com.baidu.tieba.ala.guardclub.view.d dVar) {
        this.fKV = dVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bxB() {
        return this.hasMore;
    }

    public void bxC() {
        ko(true);
    }

    public void ko(boolean z) {
        this.eSL = z;
        if (z) {
            this.fKW = 1;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            bxE();
        } else if (this.fKV != null) {
            this.fKV.brE();
        }
    }

    public void bxD() {
        this.eSL = false;
        if (this.fKV != null) {
            this.fKV.btK();
            bxE();
        }
    }

    private void bxE() {
        f fVar = new f();
        fVar.setPn(this.fKW);
        fVar.setPs(20);
        fVar.setParams();
        fVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(fVar);
    }

    public void a(String str, b bVar) {
        j jVar = new j();
        jVar.Cr(str);
        jVar.setParams();
        jVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(jVar);
        this.fKX = bVar;
    }

    private void bxF() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021139, TbConfig.SERVER_HOST + "liveserver/guardClub/joinlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bxG() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/guardClub/quit");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GuardClubQuitHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.fKY != null) {
            MessageManager.getInstance().unRegisterListener(this.fKY);
        }
        if (this.fKZ != null) {
            MessageManager.getInstance().unRegisterListener(this.fKY);
        }
        MessageManager.getInstance().unRegisterTask(1021139);
    }
}
