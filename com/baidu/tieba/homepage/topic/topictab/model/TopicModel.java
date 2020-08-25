package com.baidu.tieba.homepage.topic.topictab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.a;
import com.baidu.adp.lib.util.j;
import com.baidu.tieba.homepage.topic.topictab.message.RequestGetTopicListMessage;
/* loaded from: classes16.dex */
public class TopicModel extends BdBaseModel {
    private a dOR;
    private a iNG;
    private com.baidu.tieba.homepage.topic.topictab.a iUT;
    private boolean mIsLoading;

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.iUT = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.dOR.setTag(bdUniqueId);
        registerListener(this.dOR);
        this.iNG.setTag(bdUniqueId);
        registerListener(this.iNG);
    }

    public void czi() {
        if (!j.isNetworkAvailableForImmediately()) {
            if (this.iUT != null) {
                this.iUT.o(-1, null);
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
        MessageManager.getInstance().unRegisterListener(this.dOR);
        MessageManager.getInstance().unRegisterListener(this.iNG);
        this.mIsLoading = false;
    }
}
