package com.baidu.tieba.homepage.topic.topicdetail.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.t;
import tbclient.CommonReq;
import tbclient.NewTopicThread.DataReq;
import tbclient.NewTopicThread.NewTopicThreadReqIdl;
/* loaded from: classes16.dex */
public class RequestGetTopicThreadMessage extends NetMessage {
    private String callFrom;

    /* renamed from: common  reason: collision with root package name */
    private CommonReq f980common;
    private long lastFeedId;
    private long pageNo;
    private long topicId;

    public RequestGetTopicThreadMessage() {
        super(CmdConfigHttp.CMD_TOPIC_THREAD, 309631);
    }

    public void setCommon(CommonReq commonReq) {
        this.f980common = commonReq;
    }

    public void setTopicId(long j) {
        this.topicId = j;
    }

    public void setPageNo(long j) {
        this.pageNo = j;
    }

    public void setLastFeedId(long j) {
        this.lastFeedId = j;
    }

    public void setCallFrom(String str) {
        this.callFrom = str;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.f1170common = this.f980common;
        builder.topic_id = Long.valueOf(this.topicId);
        builder.page_no = Long.valueOf(this.pageNo);
        builder.last_feed_id = Long.valueOf(this.lastFeedId);
        builder.call_from = this.callFrom;
        if (z) {
            t.a(builder, true);
        }
        NewTopicThreadReqIdl.Builder builder2 = new NewTopicThreadReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
