package com.baidu.tieba.homepage.topic.topictab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.a;
import com.baidu.adp.lib.util.j;
import com.baidu.tieba.homepage.topic.topictab.message.RequestGetTopicListMessage;
/* loaded from: classes16.dex */
public class TopicModel extends BdBaseModel {
    private a dFJ;
    private com.baidu.tieba.homepage.topic.topictab.a iFT;
    private a iyO;
    private boolean mIsLoading;

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.iFT = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.dFJ.setTag(bdUniqueId);
        registerListener(this.dFJ);
        this.iyO.setTag(bdUniqueId);
        registerListener(this.iyO);
    }

    public void cop() {
        if (!j.isNetworkAvailableForImmediately()) {
            if (this.iFT != null) {
                this.iFT.n(-1, null);
            }
        } else if (!this.mIsLoading) {
            cancelLoadData();
            RequestGetTopicListMessage requestGetTopicListMessage = new RequestGetTopicListMessage();
            requestGetTopicListMessage.setCallFrom("topic_tab");
            requestGetTopicListMessage.setTag(this.unique_id);
            if (MessageManager.getInstance().sendMessage(requestGetTopicListMessage)) {
                this.mIsLoading = true;
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dFJ);
        MessageManager.getInstance().unRegisterListener(this.iyO);
        this.mIsLoading = false;
    }
}
