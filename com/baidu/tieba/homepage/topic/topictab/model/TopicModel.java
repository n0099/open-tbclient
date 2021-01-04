package com.baidu.tieba.homepage.topic.topictab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.a;
import com.baidu.adp.lib.util.j;
import com.baidu.tieba.homepage.topic.topictab.message.RequestGetTopicListMessage;
/* loaded from: classes2.dex */
public class TopicModel extends BdBaseModel {
    private a eFZ;
    private a kfy;
    private com.baidu.tieba.homepage.topic.topictab.a kmC;
    private boolean mIsLoading;

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.kmC = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.eFZ.setTag(bdUniqueId);
        registerListener(this.eFZ);
        this.kfy.setTag(bdUniqueId);
        registerListener(this.kfy);
    }

    public void cUj() {
        if (!j.isNetworkAvailableForImmediately()) {
            if (this.kmC != null) {
                this.kmC.o(-1, null);
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
        MessageManager.getInstance().unRegisterListener(this.eFZ);
        MessageManager.getInstance().unRegisterListener(this.kfy);
        this.mIsLoading = false;
    }
}
