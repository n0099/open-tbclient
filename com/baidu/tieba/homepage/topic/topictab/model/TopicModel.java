package com.baidu.tieba.homepage.topic.topictab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.a;
import com.baidu.adp.lib.util.j;
import com.baidu.tieba.homepage.topic.topictab.message.RequestGetTopicListMessage;
/* loaded from: classes22.dex */
public class TopicModel extends BdBaseModel {
    private a ewJ;
    private a jSn;
    private com.baidu.tieba.homepage.topic.topictab.a jZr;
    private boolean mIsLoading;

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.jZr = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.ewJ.setTag(bdUniqueId);
        registerListener(this.ewJ);
        this.jSn.setTag(bdUniqueId);
        registerListener(this.jSn);
    }

    public void cRd() {
        if (!j.isNetworkAvailableForImmediately()) {
            if (this.jZr != null) {
                this.jZr.o(-1, null);
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
        MessageManager.getInstance().unRegisterListener(this.ewJ);
        MessageManager.getInstance().unRegisterListener(this.jSn);
        this.mIsLoading = false;
    }
}
