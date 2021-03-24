package com.baidu.tieba.homepage.topic.topicdetail.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.h0.z0.w;
import tbclient.CommonReq;
import tbclient.NewHottopic.DataReq;
import tbclient.NewHottopic.NewHottopicReqIdl;
/* loaded from: classes4.dex */
public class RequestGetTopicDetailMessage extends NetMessage {
    public String callFrom;

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f17374common;
    public long topicId;

    public RequestGetTopicDetailMessage() {
        super(CmdConfigHttp.CMD_TOPIC_DETAIL, 309629);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.f68548common = this.f17374common;
        builder.topic_id = Long.valueOf(this.topicId);
        builder.call_from = this.callFrom;
        if (z) {
            w.a(builder, true);
        }
        NewHottopicReqIdl.Builder builder2 = new NewHottopicReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setCallFrom(String str) {
        this.callFrom = str;
    }

    public void setCommon(CommonReq commonReq) {
        this.f17374common = commonReq;
    }

    public void setTopicId(long j) {
        this.topicId = j;
    }
}
