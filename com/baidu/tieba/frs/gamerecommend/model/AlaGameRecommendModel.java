package com.baidu.tieba.frs.gamerecommend.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.gamerecommend.message.AlaGameRecommendReponseMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaGameRecommendModel extends BdBaseModel {
    public static final int FIRST_PN = 1;
    private boolean bsI;
    private HttpMessageListener dtj;
    private a dtk;
    private boolean hasMore;
    private String mForumId;
    private int mPn;
    private BdUniqueId buy = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.b.a dtl = new com.baidu.tieba.frs.gamerecommend.b.a();

    /* loaded from: classes3.dex */
    public interface a {
        void a(boolean z, List<h> list);

        void b(int i, String str, boolean z);
    }

    static /* synthetic */ int d(AlaGameRecommendModel alaGameRecommendModel) {
        int i = alaGameRecommendModel.mPn;
        alaGameRecommendModel.mPn = i + 1;
        return i;
    }

    public AlaGameRecommendModel(String str, a aVar) {
        this.mForumId = str;
        this.dtk = aVar;
        awT();
        registerListener();
    }

    private void awT() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO, TbConfig.SERVER_ADDRESS + "c/f/game/gameForumRecomTab");
        tbHttpMessageTask.setResponsedClass(AlaGameRecommendReponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        this.dtj = new HttpMessageListener(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO) { // from class: com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003401 && (httpResponsedMessage instanceof AlaGameRecommendReponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaGameRecommendModel.this.buy) {
                    AlaGameRecommendReponseMessage alaGameRecommendReponseMessage = (AlaGameRecommendReponseMessage) httpResponsedMessage;
                    if (alaGameRecommendReponseMessage.hasError() || alaGameRecommendReponseMessage.getError() != 0) {
                        if (AlaGameRecommendModel.this.dtk != null) {
                            AlaGameRecommendModel.this.dtk.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaGameRecommendModel.this.bsI);
                        }
                    } else {
                        com.baidu.tieba.frs.gamerecommend.data.a data = alaGameRecommendReponseMessage.getData();
                        if (data != null) {
                            AlaGameRecommendModel.this.hasMore = data.hasMore;
                            if (AlaGameRecommendModel.this.bsI) {
                                AlaGameRecommendModel.d(AlaGameRecommendModel.this);
                            }
                            AlaGameRecommendModel.this.dtl.a(AlaGameRecommendModel.this.mPn, data);
                            if (AlaGameRecommendModel.this.dtk != null) {
                                AlaGameRecommendModel.this.dtk.a(AlaGameRecommendModel.this.hasMore, AlaGameRecommendModel.this.dtl.getData());
                            }
                        } else {
                            return;
                        }
                    }
                    AlaGameRecommendModel.this.bsI = false;
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dtj);
    }

    public void So() {
        this.bsI = false;
        this.mPn = 1;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
        httpMessage.addParam("forum_id", this.mForumId);
        httpMessage.addParam("recom_pn", this.mPn);
        httpMessage.setTag(this.buy);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void SJ() {
        if (this.hasMore && !this.bsI) {
            this.bsI = true;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
            httpMessage.addParam("forum_id", this.mForumId);
            httpMessage.addParam("recom_pn", this.mPn + 1);
            httpMessage.setTag(this.buy);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasData() {
        return !w.z(this.dtl.getData());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
        MessageManager.getInstance().unRegisterListener(this.dtj);
    }
}
