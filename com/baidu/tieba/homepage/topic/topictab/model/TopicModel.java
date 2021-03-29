package com.baidu.tieba.homepage.topic.topictab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.homepage.topic.topictab.message.RequestGetTopicListMessage;
import d.b.b.e.p.j;
import d.b.i0.z0.j.b.a;
/* loaded from: classes3.dex */
public class TopicModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public a f17426e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.b.c.g.a f17427f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.b.c.g.a f17428g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17429h;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.f17427f);
        MessageManager.getInstance().unRegisterListener(this.f17428g);
        this.f17429h = false;
    }

    public void s() {
        if (!j.A()) {
            a aVar = this.f17426e;
            if (aVar != null) {
                aVar.netCallback(-1, null);
            }
        } else if (this.f17429h) {
        } else {
            cancelLoadData();
            RequestGetTopicListMessage requestGetTopicListMessage = new RequestGetTopicListMessage();
            requestGetTopicListMessage.setCallFrom("topic_tab");
            requestGetTopicListMessage.setTag(this.unique_id);
            if (MessageManager.getInstance().sendMessage(requestGetTopicListMessage)) {
                this.f17429h = true;
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.f17427f.setTag(bdUniqueId);
        registerListener(this.f17427f);
        this.f17428g.setTag(bdUniqueId);
        registerListener(this.f17428g);
    }

    public void t(a aVar) {
        this.f17426e = aVar;
    }
}
