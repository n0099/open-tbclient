package com.baidu.tieba.homepage.topic.topictab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.homepage.topic.topictab.message.RequestGetTopicListMessage;
import d.b.c.e.p.j;
import d.b.i0.a1.j.b.a;
/* loaded from: classes4.dex */
public class TopicModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public a f17103e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.c.c.g.a f17104f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.c.c.g.a f17105g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17106h;

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
        MessageManager.getInstance().unRegisterListener(this.f17104f);
        MessageManager.getInstance().unRegisterListener(this.f17105g);
        this.f17106h = false;
    }

    public void s() {
        if (!j.A()) {
            a aVar = this.f17103e;
            if (aVar != null) {
                aVar.netCallback(-1, null);
            }
        } else if (this.f17106h) {
        } else {
            cancelLoadData();
            RequestGetTopicListMessage requestGetTopicListMessage = new RequestGetTopicListMessage();
            requestGetTopicListMessage.setCallFrom("topic_tab");
            requestGetTopicListMessage.setTag(this.unique_id);
            if (MessageManager.getInstance().sendMessage(requestGetTopicListMessage)) {
                this.f17106h = true;
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.f17104f.setTag(bdUniqueId);
        registerListener(this.f17104f);
        this.f17105g.setTag(bdUniqueId);
        registerListener(this.f17105g);
    }

    public void t(a aVar) {
        this.f17103e = aVar;
    }
}
