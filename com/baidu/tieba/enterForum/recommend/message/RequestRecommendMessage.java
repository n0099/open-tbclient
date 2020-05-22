package com.baidu.tieba.enterForum.recommend.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.t;
import tbclient.CommonReq;
import tbclient.Recommforum.DataReq;
import tbclient.Recommforum.RecommforumReqIdl;
/* loaded from: classes9.dex */
public class RequestRecommendMessage extends NetMessage {

    /* renamed from: common  reason: collision with root package name */
    private CommonReq f1013common;

    public RequestRecommendMessage() {
        super(CmdConfigHttp.CMD_RECOMMEND_FORUM, 309630);
    }

    public void setCommon(CommonReq commonReq) {
        this.f1013common = commonReq;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.f1228common = this.f1013common;
        if (z) {
            t.a(builder, true);
        }
        RecommforumReqIdl.Builder builder2 = new RecommforumReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
