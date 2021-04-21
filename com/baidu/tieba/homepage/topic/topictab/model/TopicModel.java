package com.baidu.tieba.homepage.topic.topictab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.homepage.topic.topictab.message.RequestGetTopicListMessage;
import d.b.c.e.p.j;
import d.b.j0.a1.j.b.a;
/* loaded from: classes4.dex */
public class TopicModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public a f17111e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.c.c.g.a f17112f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.c.c.g.a f17113g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17114h;

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
        MessageManager.getInstance().unRegisterListener(this.f17112f);
        MessageManager.getInstance().unRegisterListener(this.f17113g);
        this.f17114h = false;
    }

    public void s() {
        if (!j.A()) {
            a aVar = this.f17111e;
            if (aVar != null) {
                aVar.netCallback(-1, null);
            }
        } else if (this.f17114h) {
        } else {
            cancelLoadData();
            RequestGetTopicListMessage requestGetTopicListMessage = new RequestGetTopicListMessage();
            requestGetTopicListMessage.setCallFrom("topic_tab");
            requestGetTopicListMessage.setTag(this.unique_id);
            if (MessageManager.getInstance().sendMessage(requestGetTopicListMessage)) {
                this.f17114h = true;
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.f17112f.setTag(bdUniqueId);
        registerListener(this.f17112f);
        this.f17113g.setTag(bdUniqueId);
        registerListener(this.f17113g);
    }

    public void t(a aVar) {
        this.f17111e = aVar;
    }
}
