package com.baidu.tieba.enterForum.recommend.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.u;
import tbclient.CommonReq;
import tbclient.Recommforum.DataReq;
import tbclient.Recommforum.RecommforumReqIdl;
/* loaded from: classes22.dex */
public class RequestRecommendMessage extends NetMessage {

    /* renamed from: common  reason: collision with root package name */
    private CommonReq f3680common;

    public RequestRecommendMessage() {
        super(CmdConfigHttp.CMD_RECOMMEND_FORUM, 309630);
    }

    public void setCommon(CommonReq commonReq) {
        this.f3680common = commonReq;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.f5337common = this.f3680common;
        if (z) {
            u.a(builder, true);
        }
        RecommforumReqIdl.Builder builder2 = new RecommforumReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
