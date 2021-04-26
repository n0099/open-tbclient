package com.baidu.tieba.homepage.topic.topicdetail.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.RequestGetTopicDetailMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.RequestGetTopicThreadMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseHttpGetTopicDetailMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseHttpGetTopicThreadMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseSocketGetTopicDetailMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseSocketGetTopicThreadMessage;
import com.baidu.tieba.message.RequestBlessMessage;
import d.a.c.e.p.j;
import d.a.c.j.e.n;
import java.util.List;
/* loaded from: classes4.dex */
public class TopicDetailModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.a1.j.a.a f17344e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.a1.j.a.c.a f17345f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f17346g;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            long j2;
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage instanceof BlessHttpResponseMessage) {
                BlessHttpResponseMessage blessHttpResponseMessage = (BlessHttpResponseMessage) responsedMessage;
                j = blessHttpResponseMessage.userPkId;
                j2 = blessHttpResponseMessage.pkID;
            } else if (responsedMessage instanceof BlessSocketResponseMessage) {
                BlessSocketResponseMessage blessSocketResponseMessage = (BlessSocketResponseMessage) responsedMessage;
                j = blessSocketResponseMessage.userPkId;
                j2 = blessSocketResponseMessage.pkID;
            } else {
                j = 0;
                j2 = 0;
            }
            if (j2 == 0 && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof RequestBlessMessage)) {
                j2 = ((RequestBlessMessage) responsedMessage.getOrginalMessage().getExtra()).pk_id.longValue();
            }
            if (j2 == 0 || TopicDetailModel.this.f17345f == null || TopicDetailModel.this.f17345f.f51069e == null || TopicDetailModel.this.f17345f.f51069e.f51078e == null || TopicDetailModel.this.f17345f.f51069e.f51078e.f51119b != j2) {
                return;
            }
            TopicDetailModel.this.f17345f.f51069e.f51078e.f51120c = j;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.c.c.g.a {
        public b(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || TopicDetailModel.this.unique_id != responsedMessage.getOrginalMessage().getTag() || TopicDetailModel.this.f17344e == null) {
                return;
            }
            if (responsedMessage instanceof ResponseHttpGetTopicDetailMessage) {
                TopicDetailModel.this.f17345f = ((ResponseHttpGetTopicDetailMessage) responsedMessage).getTopicDetailData();
            }
            if (responsedMessage instanceof ResponseSocketGetTopicDetailMessage) {
                TopicDetailModel.this.f17345f = ((ResponseSocketGetTopicDetailMessage) responsedMessage).getTopicDetailData();
            }
            TopicDetailModel.this.f17344e.netCallback(responsedMessage.getError(), TopicDetailModel.this.f17345f);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.a.c.c.g.a {
        public c(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || TopicDetailModel.this.unique_id != responsedMessage.getOrginalMessage().getTag() || TopicDetailModel.this.f17344e == null) {
                return;
            }
            List<n> list = null;
            boolean z = false;
            if (responsedMessage instanceof ResponseHttpGetTopicThreadMessage) {
                ResponseHttpGetTopicThreadMessage responseHttpGetTopicThreadMessage = (ResponseHttpGetTopicThreadMessage) responsedMessage;
                List<n> dataList = responseHttpGetTopicThreadMessage.getDataList();
                z = responseHttpGetTopicThreadMessage.getHasMore();
                list = dataList;
            }
            if (responsedMessage instanceof ResponseSocketGetTopicThreadMessage) {
                ResponseSocketGetTopicThreadMessage responseSocketGetTopicThreadMessage = (ResponseSocketGetTopicThreadMessage) responsedMessage;
                List<n> dataList2 = responseSocketGetTopicThreadMessage.getDataList();
                z = responseSocketGetTopicThreadMessage.getHasMore();
                list = dataList2;
            }
            TopicDetailModel.this.f17344e.netThreadCallback(responsedMessage.getError(), z, list);
        }
    }

    public TopicDetailModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.f17346g = new a(CmdConfigHttp.CMD_TOPIC_BLESS, 309085);
        registerListener(new b(CmdConfigHttp.CMD_TOPIC_DETAIL, 309629));
        registerListener(new c(CmdConfigHttp.CMD_TOPIC_THREAD, 309631));
        registerListener(this.f17346g);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void x(long j) {
        if (!j.A()) {
            d.a.j0.a1.j.a.a aVar = this.f17344e;
            if (aVar != null) {
                aVar.netCallback(-1, null);
                return;
            }
            return;
        }
        RequestGetTopicDetailMessage requestGetTopicDetailMessage = new RequestGetTopicDetailMessage();
        requestGetTopicDetailMessage.setTopicId(j);
        requestGetTopicDetailMessage.setCallFrom("topic_tab");
        requestGetTopicDetailMessage.setTag(this.unique_id);
        sendMessage(requestGetTopicDetailMessage);
    }

    public void y(long j, long j2, long j3) {
        if (!j.A()) {
            d.a.j0.a1.j.a.a aVar = this.f17344e;
            if (aVar != null) {
                aVar.netThreadCallback(-1, false, null);
                return;
            }
            return;
        }
        RequestGetTopicThreadMessage requestGetTopicThreadMessage = new RequestGetTopicThreadMessage();
        requestGetTopicThreadMessage.setTopicId(j);
        requestGetTopicThreadMessage.setPageNo(j2);
        requestGetTopicThreadMessage.setLastFeedId(j3);
        requestGetTopicThreadMessage.setCallFrom("topic_tab");
        requestGetTopicThreadMessage.setTag(this.unique_id);
        sendMessage(requestGetTopicThreadMessage);
    }

    public void z(d.a.j0.a1.j.a.a aVar) {
        this.f17344e = aVar;
    }
}
