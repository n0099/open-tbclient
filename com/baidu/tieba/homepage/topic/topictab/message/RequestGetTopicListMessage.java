package com.baidu.tieba.homepage.topic.topictab.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.t;
import tbclient.CommonReq;
import tbclient.NewTopicList.DataReq;
import tbclient.NewTopicList.NewTopicListReqIdl;
/* loaded from: classes7.dex */
public class RequestGetTopicListMessage extends NetMessage {
    private String callFrom;

    /* renamed from: common  reason: collision with root package name */
    private CommonReq f977common;

    public RequestGetTopicListMessage() {
        super(CmdConfigHttp.CMD_TOPIC_LIST, 309628);
    }

    public void setCommon(CommonReq commonReq) {
        this.f977common = commonReq;
    }

    public void setCallFrom(String str) {
        this.callFrom = str;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.f1138common = this.f977common;
        builder.call_from = this.callFrom;
        if (z) {
            t.a(builder, true);
        }
        NewTopicListReqIdl.Builder builder2 = new NewTopicListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
