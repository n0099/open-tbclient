package com.baidu.tieba.enterForum.recommend.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.j0.z0.w;
import tbclient.CommonReq;
import tbclient.Recommforum.DataReq;
import tbclient.Recommforum.RecommforumReqIdl;
/* loaded from: classes4.dex */
public class RequestRecommendMessage extends NetMessage {

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f14603common;

    public RequestRecommendMessage() {
        super(CmdConfigHttp.CMD_RECOMMEND_FORUM, 309630);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.f69473common = this.f14603common;
        if (z) {
            w.a(builder, true);
        }
        RecommforumReqIdl.Builder builder2 = new RecommforumReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setCommon(CommonReq commonReq) {
        this.f14603common = commonReq;
    }
}
