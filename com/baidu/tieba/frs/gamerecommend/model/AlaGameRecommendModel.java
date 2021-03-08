package com.baidu.tieba.frs.gamerecommend.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.gamerecommend.message.AlaGameRecommendReponseMessage;
import java.util.List;
/* loaded from: classes2.dex */
public class AlaGameRecommendModel extends BdBaseModel {
    public static final int FIRST_PN = 1;
    private boolean hasMore;
    private boolean isLoadMore;
    private HttpMessageListener jBJ;
    private a jBK;
    private String mForumId;
    private int mPn;
    private BdUniqueId mCurTag = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.a.a jBL = new com.baidu.tieba.frs.gamerecommend.a.a();

    /* loaded from: classes2.dex */
    public interface a {
        void g(int i, String str, boolean z);

        void g(boolean z, List<n> list);
    }

    static /* synthetic */ int d(AlaGameRecommendModel alaGameRecommendModel) {
        int i = alaGameRecommendModel.mPn;
        alaGameRecommendModel.mPn = i + 1;
        return i;
    }

    public AlaGameRecommendModel(String str, a aVar) {
        this.mForumId = str;
        this.jBK = aVar;
        cIr();
        registerListener();
    }

    private void cIr() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003401, TbConfig.SERVER_ADDRESS + Config.GAME_RECOMMEND_TAB);
        tbHttpMessageTask.setResponsedClass(AlaGameRecommendReponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        this.jBJ = new HttpMessageListener(1003401) { // from class: com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003401 && (httpResponsedMessage instanceof AlaGameRecommendReponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaGameRecommendModel.this.mCurTag) {
                    AlaGameRecommendReponseMessage alaGameRecommendReponseMessage = (AlaGameRecommendReponseMessage) httpResponsedMessage;
                    if (alaGameRecommendReponseMessage.hasError() || alaGameRecommendReponseMessage.getError() != 0) {
                        if (AlaGameRecommendModel.this.jBK != null) {
                            AlaGameRecommendModel.this.jBK.g(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaGameRecommendModel.this.isLoadMore);
                        }
                    } else {
                        com.baidu.tieba.frs.gamerecommend.data.a data = alaGameRecommendReponseMessage.getData();
                        if (data != null) {
                            AlaGameRecommendModel.this.hasMore = data.hasMore;
                            if (AlaGameRecommendModel.this.isLoadMore) {
                                AlaGameRecommendModel.d(AlaGameRecommendModel.this);
                            }
                            AlaGameRecommendModel.this.jBL.a(AlaGameRecommendModel.this.mPn, data);
                            if (AlaGameRecommendModel.this.jBK != null) {
                                AlaGameRecommendModel.this.jBK.g(AlaGameRecommendModel.this.hasMore, AlaGameRecommendModel.this.jBL.getData());
                            }
                        } else {
                            return;
                        }
                    }
                    AlaGameRecommendModel.this.isLoadMore = false;
                }
            }
        };
        MessageManager.getInstance().registerListener(this.jBJ);
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

    public void bRp() {
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
        return !y.isEmpty(this.jBL.getData());
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
        MessageManager.getInstance().unRegisterListener(this.jBJ);
    }
}
