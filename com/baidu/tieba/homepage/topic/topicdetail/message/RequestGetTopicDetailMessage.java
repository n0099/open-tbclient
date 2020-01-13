package com.baidu.tieba.homepage.topic.topicdetail.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.t;
import tbclient.CommonReq;
import tbclient.NewHottopic.DataReq;
import tbclient.NewHottopic.NewHottopicReqIdl;
/* loaded from: classes7.dex */
public class RequestGetTopicDetailMessage extends NetMessage {
    private String callFrom;

    /* renamed from: common  reason: collision with root package name */
    private CommonReq f975common;
    private long topicId;

    public RequestGetTopicDetailMessage() {
        super(CmdConfigHttp.CMD_TOPIC_DETAIL, 309629);
    }

    public void setCommon(CommonReq commonReq) {
        this.f975common = commonReq;
    }

    public void setTopicId(long j) {
        this.topicId = j;
    }

    public void setCallFrom(String str) {
        this.callFrom = str;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.f1136common = this.f975common;
        builder.topic_id = Long.valueOf(this.topicId);
        builder.call_from = this.callFrom;
        if (z) {
            t.a(builder, true);
        }
        NewHottopicReqIdl.Builder builder2 = new NewHottopicReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
