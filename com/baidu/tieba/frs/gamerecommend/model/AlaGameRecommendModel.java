package com.baidu.tieba.frs.gamerecommend.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.gamerecommend.message.AlaGameRecommendReponseMessage;
import java.util.List;
/* loaded from: classes9.dex */
public class AlaGameRecommendModel extends BdBaseModel {
    public static final int FIRST_PN = 1;
    private boolean hasMore;
    private HttpMessageListener hmJ;
    private a hmK;
    private boolean isLoadMore;
    private String mForumId;
    private int mPn;
    private BdUniqueId mCurTag = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.b.a hmL = new com.baidu.tieba.frs.gamerecommend.b.a();

    /* loaded from: classes9.dex */
    public interface a {
        void d(boolean z, List<m> list);

        void f(int i, String str, boolean z);
    }

    static /* synthetic */ int d(AlaGameRecommendModel alaGameRecommendModel) {
        int i = alaGameRecommendModel.mPn;
        alaGameRecommendModel.mPn = i + 1;
        return i;
    }

    public AlaGameRecommendModel(String str, a aVar) {
        this.mForumId = str;
        this.hmK = aVar;
        bSD();
        registerListener();
    }

    private void bSD() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003401, TbConfig.SERVER_ADDRESS + Config.GAME_RECOMMEND_TAB);
        tbHttpMessageTask.setResponsedClass(AlaGameRecommendReponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        this.hmJ = new HttpMessageListener(1003401) { // from class: com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003401 && (httpResponsedMessage instanceof AlaGameRecommendReponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaGameRecommendModel.this.mCurTag) {
                    AlaGameRecommendReponseMessage alaGameRecommendReponseMessage = (AlaGameRecommendReponseMessage) httpResponsedMessage;
                    if (alaGameRecommendReponseMessage.hasError() || alaGameRecommendReponseMessage.getError() != 0) {
                        if (AlaGameRecommendModel.this.hmK != null) {
                            AlaGameRecommendModel.this.hmK.f(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaGameRecommendModel.this.isLoadMore);
                        }
                    } else {
                        com.baidu.tieba.frs.gamerecommend.data.a data = alaGameRecommendReponseMessage.getData();
                        if (data != null) {
                            AlaGameRecommendModel.this.hasMore = data.hasMore;
                            if (AlaGameRecommendModel.this.isLoadMore) {
                                AlaGameRecommendModel.d(AlaGameRecommendModel.this);
                            }
                            AlaGameRecommendModel.this.hmL.a(AlaGameRecommendModel.this.mPn, data);
                            if (AlaGameRecommendModel.this.hmK != null) {
                                AlaGameRecommendModel.this.hmK.d(AlaGameRecommendModel.this.hasMore, AlaGameRecommendModel.this.hmL.getData());
                            }
                        } else {
                            return;
                        }
                    }
                    AlaGameRecommendModel.this.isLoadMore = false;
                }
            }
        };
        MessageManager.getInstance().registerListener(this.hmJ);
    }

    public void loadData() {
        this.isLoadMore = false;
        this.mPn = 1;
        HttpMessage httpMessage = new HttpMessage(1003401);
        httpMessage.addParam("forum_id", this.mForumId);
        httpMessage.addParam("recom_pn", this.mPn);
        httpMessage.setTag(this.mCurTag);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void blb() {
        if (this.hasMore && !this.isLoadMore) {
            this.isLoadMore = true;
            HttpMessage httpMessage = new HttpMessage(1003401);
            httpMessage.addParam("forum_id", this.mForumId);
            httpMessage.addParam("recom_pn", this.mPn + 1);
            httpMessage.setTag(this.mCurTag);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasData() {
        return !v.isEmpty(this.hmL.getData());
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
        MessageManager.getInstance().unRegisterTask(1003401);
        MessageManager.getInstance().unRegisterListener(this.hmJ);
    }
}
