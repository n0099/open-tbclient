package com.baidu.tieba.homepage.topic.topictab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.a;
import com.baidu.adp.lib.util.j;
import com.baidu.tieba.homepage.topic.topictab.message.RequestGetTopicListMessage;
/* loaded from: classes21.dex */
public class TopicModel extends BdBaseModel {
    private a dRa;
    private a iWs;
    private com.baidu.tieba.homepage.topic.topictab.a jdF;
    private boolean mIsLoading;

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.jdF = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.dRa.setTag(bdUniqueId);
        registerListener(this.dRa);
        this.iWs.setTag(bdUniqueId);
        registerListener(this.iWs);
    }

    public void cCQ() {
        if (!j.isNetworkAvailableForImmediately()) {
            if (this.jdF != null) {
                this.jdF.o(-1, null);
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
        MessageManager.getInstance().unRegisterListener(this.dRa);
        MessageManager.getInstance().unRegisterListener(this.iWs);
        this.mIsLoading = false;
    }
}
