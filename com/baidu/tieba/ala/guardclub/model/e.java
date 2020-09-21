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
/* loaded from: classes4.dex */
public class e extends BdBaseModel<GuardClubJoinListActivity> {
    private boolean fnv;
    private a gee;
    private com.baidu.tieba.ala.guardclub.view.d gfE;
    private b gfG;
    private boolean hasMore;
    private int gfF = 1;
    private HttpMessageListener gfH = new HttpMessageListener(1021139) { // from class: com.baidu.tieba.ala.guardclub.model.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubJoinListHttpResponseMessage)) {
                if (e.this.gfE != null) {
                    e.this.gfE.bET();
                    return;
                }
                return;
            }
            GuardClubJoinListHttpResponseMessage guardClubJoinListHttpResponseMessage = (GuardClubJoinListHttpResponseMessage) httpResponsedMessage;
            if (guardClubJoinListHttpResponseMessage.getError() != 0) {
                if (e.this.gfE != null) {
                    e.this.gfE.bET();
                    return;
                }
                return;
            }
            e.this.hasMore = guardClubJoinListHttpResponseMessage.hasMore;
            if (e.this.gfE != null) {
                if (e.this.fnv) {
                    e.this.gfE.bR(guardClubJoinListHttpResponseMessage.gfC);
                    e.this.gfE.completePullRefresh();
                } else {
                    e.this.gfE.bS(guardClubJoinListHttpResponseMessage.gfC);
                }
                if (guardClubJoinListHttpResponseMessage.hasMore) {
                    e.this.gfE.bLs();
                } else if (!e.this.fnv) {
                    e.this.gfE.lv(e.this.gfF == 1);
                }
                e.this.gfF++;
            }
        }
    };
    private HttpMessageListener gfI = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.guardclub.model.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubQuitHttpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == e.this.unique_id && httpResponsedMessage.getError() == 0 && e.this.gfG != null) {
                e.this.gfG.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
    }

    /* loaded from: classes4.dex */
    public interface b {
        void b(int i, String str, Object obj);
    }

    public e(BdUniqueId bdUniqueId, a aVar) {
        this.unique_id = bdUniqueId;
        this.gee = aVar;
        bLA();
        bLB();
        MessageManager.getInstance().registerListener(this.gfH);
        MessageManager.getInstance().registerListener(this.gfI);
    }

    public void a(com.baidu.tieba.ala.guardclub.view.d dVar) {
        this.gfE = dVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bLw() {
        return this.hasMore;
    }

    public void bLx() {
        lw(true);
    }

    public void lw(boolean z) {
        this.fnv = z;
        if (z) {
            this.gfF = 1;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            bLz();
        } else if (this.gfE != null) {
            this.gfE.bET();
        }
    }

    public void bLy() {
        this.fnv = false;
        if (this.gfE != null) {
            this.gfE.bHj();
            bLz();
        }
    }

    private void bLz() {
        f fVar = new f();
        fVar.setPn(this.gfF);
        fVar.setPs(20);
        fVar.setParams();
        fVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(fVar);
    }

    public void a(String str, b bVar) {
        j jVar = new j();
        jVar.FW(str);
        jVar.setParams();
        jVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(jVar);
        this.gfG = bVar;
    }

    private void bLA() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021139, TbConfig.SERVER_HOST + "liveserver/guardClub/joinlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bLB() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/guardClub/quit");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GuardClubQuitHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.gfH != null) {
            MessageManager.getInstance().unRegisterListener(this.gfH);
        }
        if (this.gfI != null) {
            MessageManager.getInstance().unRegisterListener(this.gfH);
        }
        MessageManager.getInstance().unRegisterTask(1021139);
    }
}
