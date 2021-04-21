package com.baidu.tieba.homepage.topic.topictab.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.i0.z0.w;
import tbclient.CommonReq;
import tbclient.NewTopicList.DataReq;
import tbclient.NewTopicList.NewTopicListReqIdl;
/* loaded from: classes4.dex */
public class RequestGetTopicListMessage extends NetMessage {
    public String callFrom;

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f17110common;

    public RequestGetTopicListMessage() {
        super(CmdConfigHttp.CMD_TOPIC_LIST, 309628);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.f69708common = this.f17110common;
        builder.call_from = this.callFrom;
        if (z) {
            w.a(builder, true);
        }
        NewTopicListReqIdl.Builder builder2 = new NewTopicListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setCallFrom(String str) {
        this.callFrom = str;
    }

    public void setCommon(CommonReq commonReq) {
        this.f17110common = commonReq;
    }
}
