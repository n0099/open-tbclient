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
    private boolean dTv;
    private a eFw;
    private com.baidu.tieba.ala.guardclub.view.d eHc;
    private b eHe;
    private boolean hasMore;
    private int eHd = 1;
    private HttpMessageListener eHf = new HttpMessageListener(1021139) { // from class: com.baidu.tieba.ala.guardclub.model.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubJoinListHttpResponseMessage)) {
                if (e.this.eHc != null) {
                    e.this.eHc.bbC();
                    return;
                }
                return;
            }
            GuardClubJoinListHttpResponseMessage guardClubJoinListHttpResponseMessage = (GuardClubJoinListHttpResponseMessage) httpResponsedMessage;
            if (guardClubJoinListHttpResponseMessage.getError() != 0) {
                if (e.this.eHc != null) {
                    e.this.eHc.bbC();
                    return;
                }
                return;
            }
            e.this.hasMore = guardClubJoinListHttpResponseMessage.hasMore;
            if (e.this.eHc != null) {
                if (e.this.dTv) {
                    e.this.eHc.bs(guardClubJoinListHttpResponseMessage.eHa);
                    e.this.eHc.completePullRefresh();
                } else {
                    e.this.eHc.bt(guardClubJoinListHttpResponseMessage.eHa);
                }
                if (guardClubJoinListHttpResponseMessage.hasMore) {
                    e.this.eHc.bfm();
                } else if (!e.this.dTv) {
                    e.this.eHc.iD(e.this.eHd == 1);
                }
                e.this.eHd++;
            }
        }
    };
    private HttpMessageListener eHg = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.guardclub.model.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubQuitHttpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == e.this.unique_id && httpResponsedMessage.getError() == 0 && e.this.eHe != null) {
                e.this.eHe.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
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
        this.eFw = aVar;
        bfv();
        bfw();
        MessageManager.getInstance().registerListener(this.eHf);
        MessageManager.getInstance().registerListener(this.eHg);
    }

    public void a(com.baidu.tieba.ala.guardclub.view.d dVar) {
        this.eHc = dVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bfr() {
        return this.hasMore;
    }

    public void bfs() {
        iE(true);
    }

    public void iE(boolean z) {
        this.dTv = z;
        if (z) {
            this.eHd = 1;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            bfu();
        } else if (this.eHc != null) {
            this.eHc.bbC();
        }
    }

    public void bft() {
        this.dTv = false;
        if (this.eHc != null) {
            this.eHc.bcv();
            bfu();
        }
    }

    private void bfu() {
        f fVar = new f();
        fVar.setPn(this.eHd);
        fVar.setPs(20);
        fVar.setParams();
        fVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(fVar);
    }

    public void a(String str, b bVar) {
        j jVar = new j();
        jVar.yA(str);
        jVar.setParams();
        jVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(jVar);
        this.eHe = bVar;
    }

    private void bfv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021139, TbConfig.SERVER_HOST + "liveserver/guardClub/joinlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bfw() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/guardClub/quit");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GuardClubQuitHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.eHf != null) {
            MessageManager.getInstance().unRegisterListener(this.eHf);
        }
        if (this.eHg != null) {
            MessageManager.getInstance().unRegisterListener(this.eHf);
        }
        MessageManager.getInstance().unRegisterTask(1021139);
    }
}
