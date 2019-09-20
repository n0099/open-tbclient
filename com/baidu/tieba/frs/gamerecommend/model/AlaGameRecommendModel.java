package com.baidu.tieba.frs.gamerecommend.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.gamerecommend.message.AlaGameRecommendReponseMessage;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaGameRecommendModel extends BdBaseModel {
    public static final int FIRST_PN = 1;
    private HttpMessageListener fKa;
    private a fKb;
    private boolean hasMore;
    private boolean isLoadMore;
    private String mForumId;
    private int mPn;
    private BdUniqueId mCurTag = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.b.a fKc = new com.baidu.tieba.frs.gamerecommend.b.a();

    /* loaded from: classes4.dex */
    public interface a {
        void a(boolean z, List<m> list);

        void e(int i, String str, boolean z);
    }

    static /* synthetic */ int d(AlaGameRecommendModel alaGameRecommendModel) {
        int i = alaGameRecommendModel.mPn;
        alaGameRecommendModel.mPn = i + 1;
        return i;
    }

    public AlaGameRecommendModel(String str, a aVar) {
        this.mForumId = str;
        this.fKb = aVar;
        bqL();
        registerListener();
    }

    private void bqL() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO, TbConfig.SERVER_ADDRESS + "c/f/game/gameForumRecomTab");
        tbHttpMessageTask.setResponsedClass(AlaGameRecommendReponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        this.fKa = new HttpMessageListener(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO) { // from class: com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003401 && (httpResponsedMessage instanceof AlaGameRecommendReponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaGameRecommendModel.this.mCurTag) {
                    AlaGameRecommendReponseMessage alaGameRecommendReponseMessage = (AlaGameRecommendReponseMessage) httpResponsedMessage;
                    if (alaGameRecommendReponseMessage.hasError() || alaGameRecommendReponseMessage.getError() != 0) {
                        if (AlaGameRecommendModel.this.fKb != null) {
                            AlaGameRecommendModel.this.fKb.e(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaGameRecommendModel.this.isLoadMore);
                        }
                    } else {
                        com.baidu.tieba.frs.gamerecommend.data.a data = alaGameRecommendReponseMessage.getData();
                        if (data != null) {
                            AlaGameRecommendModel.this.hasMore = data.hasMore;
                            if (AlaGameRecommendModel.this.isLoadMore) {
                                AlaGameRecommendModel.d(AlaGameRecommendModel.this);
                            }
                            AlaGameRecommendModel.this.fKc.a(AlaGameRecommendModel.this.mPn, data);
                            if (AlaGameRecommendModel.this.fKb != null) {
                                AlaGameRecommendModel.this.fKb.a(AlaGameRecommendModel.this.hasMore, AlaGameRecommendModel.this.fKc.getData());
                            }
                        } else {
                            return;
                        }
                    }
                    AlaGameRecommendModel.this.isLoadMore = false;
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fKa);
    }

    public void loadData() {
        this.isLoadMore = false;
        this.mPn = 1;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
        httpMessage.addParam("forum_id", this.mForumId);
        httpMessage.addParam("recom_pn", this.mPn);
        httpMessage.setTag(this.mCurTag);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void aJw() {
        if (this.hasMore && !this.isLoadMore) {
            this.isLoadMore = true;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
            httpMessage.addParam("forum_id", this.mForumId);
            httpMessage.addParam("recom_pn", this.mPn + 1);
            httpMessage.setTag(this.mCurTag);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasData() {
        return !v.aa(this.fKc.getData());
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
        MessageManager.getInstance().unRegisterListener(this.fKa);
    }
}
