package com.baidu.tieba.ala.alasquare.recent_history.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.alasquare.recent_history.b.b;
import com.baidu.tieba.ala.alasquare.recent_history.message.AlaRecentHistoryResponseMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaRecentHistoryModel extends BdBaseModel {
    private boolean fdk;
    private a fhl;
    private HttpMessageListener fhm;
    private boolean hasMore;
    private BdUniqueId mCurTag = BdUniqueId.gen();
    private List<b> mDataList = new ArrayList();
    private TbPageContext mPageContext;
    private int mPn;
    private int mType;

    /* loaded from: classes3.dex */
    public interface a {
        void d(boolean z, List<b> list);

        void g(int i, String str, boolean z);
    }

    static /* synthetic */ int c(AlaRecentHistoryModel alaRecentHistoryModel) {
        int i = alaRecentHistoryModel.mPn;
        alaRecentHistoryModel.mPn = i + 1;
        return i;
    }

    public AlaRecentHistoryModel(TbPageContext tbPageContext, int i, a aVar) {
        this.mPageContext = tbPageContext;
        this.mType = i;
        this.fhl = aVar;
        registerListener();
        Fv();
    }

    private void Fv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GET_RECENT_HISTORY_LIST, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_GET_RECENT_HISTORY_LIST);
        tbHttpMessageTask.setResponsedClass(AlaRecentHistoryResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        this.fhm = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_RECENT_HISTORY_LIST) { // from class: com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021082 && (httpResponsedMessage instanceof AlaRecentHistoryResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaRecentHistoryModel.this.mCurTag) {
                    AlaRecentHistoryResponseMessage alaRecentHistoryResponseMessage = (AlaRecentHistoryResponseMessage) httpResponsedMessage;
                    if (!alaRecentHistoryResponseMessage.isSuccess()) {
                        if (AlaRecentHistoryModel.this.fhl != null) {
                            AlaRecentHistoryModel.this.fhl.g(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), AlaRecentHistoryModel.this.fdk);
                        }
                    } else {
                        com.baidu.tieba.ala.alasquare.recent_history.b.a recentHistoryData = alaRecentHistoryResponseMessage.getRecentHistoryData();
                        if (recentHistoryData != null) {
                            AlaRecentHistoryModel.this.hasMore = recentHistoryData.hasMore;
                            List<b> list = recentHistoryData.fhi;
                            if (!AlaRecentHistoryModel.this.fdk) {
                                AlaRecentHistoryModel.this.mDataList.clear();
                                if (!v.isEmpty(list)) {
                                    AlaRecentHistoryModel.this.mDataList.addAll(list);
                                }
                            } else if (!v.isEmpty(list)) {
                                AlaRecentHistoryModel.c(AlaRecentHistoryModel.this);
                                AlaRecentHistoryModel.this.mDataList.addAll(list);
                            }
                            if (AlaRecentHistoryModel.this.fhl != null) {
                                AlaRecentHistoryModel.this.fhl.d(AlaRecentHistoryModel.this.hasMore, AlaRecentHistoryModel.this.mDataList);
                            }
                        } else {
                            return;
                        }
                    }
                    AlaRecentHistoryModel.this.fdk = false;
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fhm);
    }

    public void refresh() {
        this.fdk = false;
        this.mPn = 0;
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_RECENT_HISTORY_LIST);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
        httpMessage.addParam("type", this.mType);
        httpMessage.addParam(Config.PACKAGE_NAME, this.mPn);
        httpMessage.setTag(this.mCurTag);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void bqv() {
        if (this.hasMore && !this.fdk) {
            this.fdk = true;
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_RECENT_HISTORY_LIST);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
            httpMessage.addParam("type", this.mType);
            httpMessage.addParam(Config.PACKAGE_NAME, this.mPn + 1);
            httpMessage.setTag(this.mCurTag);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public List<b> getData() {
        return this.mDataList;
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
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_GET_RECENT_HISTORY_LIST);
        MessageManager.getInstance().unRegisterListener(this.fhm);
    }
}
