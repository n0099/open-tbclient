package com.baidu.tieba.homepage.topic.topicdetail.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.h0.z0.w;
import tbclient.CommonReq;
import tbclient.NewTopicThread.DataReq;
import tbclient.NewTopicThread.NewTopicThreadReqIdl;
/* loaded from: classes4.dex */
public class RequestGetTopicThreadMessage extends NetMessage {
    public String callFrom;

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f17053common;
    public long lastFeedId;
    public long pageNo;
    public long topicId;

    public RequestGetTopicThreadMessage() {
        super(CmdConfigHttp.CMD_TOPIC_THREAD, 309631);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.f69563common = this.f17053common;
        builder.topic_id = Long.valueOf(this.topicId);
        builder.page_no = Long.valueOf(this.pageNo);
        builder.last_feed_id = Long.valueOf(this.lastFeedId);
        builder.call_from = this.callFrom;
        if (z) {
            w.a(builder, true);
        }
        NewTopicThreadReqIdl.Builder builder2 = new NewTopicThreadReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setCallFrom(String str) {
        this.callFrom = str;
    }

    public void setCommon(CommonReq commonReq) {
        this.f17053common = commonReq;
    }

    public void setLastFeedId(long j) {
        this.lastFeedId = j;
    }

    public void setPageNo(long j) {
        this.pageNo = j;
    }

    public void setTopicId(long j) {
        this.topicId = j;
    }
}
