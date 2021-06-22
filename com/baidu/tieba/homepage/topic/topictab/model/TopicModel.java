package com.baidu.tieba.homepage.topic.topictab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.homepage.topic.topictab.message.RequestGetTopicListMessage;
import d.a.c.e.p.j;
import d.a.o0.b1.k.b.a;
/* loaded from: classes4.dex */
public class TopicModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public a f16780e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.c.g.a f16781f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f16782g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16783h;

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
        MessageManager.getInstance().unRegisterListener(this.f16781f);
        MessageManager.getInstance().unRegisterListener(this.f16782g);
        this.f16783h = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.f16781f.setTag(bdUniqueId);
        registerListener(this.f16781f);
        this.f16782g.setTag(bdUniqueId);
        registerListener(this.f16782g);
    }

    public void w() {
        if (!j.A()) {
            a aVar = this.f16780e;
            if (aVar != null) {
                aVar.netCallback(-1, null);
            }
        } else if (this.f16783h) {
        } else {
            cancelLoadData();
            RequestGetTopicListMessage requestGetTopicListMessage = new RequestGetTopicListMessage();
            requestGetTopicListMessage.setCallFrom("topic_tab");
            requestGetTopicListMessage.setTag(this.unique_id);
            if (MessageManager.getInstance().sendMessage(requestGetTopicListMessage)) {
                this.f16783h = true;
            }
        }
    }

    public void x(a aVar) {
        this.f16780e = aVar;
    }
}
