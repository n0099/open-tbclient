package com.baidu.tieba.homepage.topic.topictab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.homepage.topic.topictab.message.RequestGetTopicListMessage;
import d.a.c.e.p.j;
import d.a.k0.a1.j.b.a;
/* loaded from: classes4.dex */
public class TopicModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public a f16712e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.c.g.a f16713f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f16714g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16715h;

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
        MessageManager.getInstance().unRegisterListener(this.f16713f);
        MessageManager.getInstance().unRegisterListener(this.f16714g);
        this.f16715h = false;
    }

    public void s() {
        if (!j.A()) {
            a aVar = this.f16712e;
            if (aVar != null) {
                aVar.netCallback(-1, null);
            }
        } else if (this.f16715h) {
        } else {
            cancelLoadData();
            RequestGetTopicListMessage requestGetTopicListMessage = new RequestGetTopicListMessage();
            requestGetTopicListMessage.setCallFrom("topic_tab");
            requestGetTopicListMessage.setTag(this.unique_id);
            if (MessageManager.getInstance().sendMessage(requestGetTopicListMessage)) {
                this.f16715h = true;
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.f16713f.setTag(bdUniqueId);
        registerListener(this.f16713f);
        this.f16714g.setTag(bdUniqueId);
        registerListener(this.f16714g);
    }

    public void t(a aVar) {
        this.f16712e = aVar;
    }
}
