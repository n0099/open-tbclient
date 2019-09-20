package com.baidu.tieba.enterForum.recommend.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.r;
import tbclient.CommonReq;
import tbclient.Recommforum.DataReq;
import tbclient.Recommforum.RecommforumReqIdl;
/* loaded from: classes4.dex */
public class RequestRecommendMessage extends NetMessage {
    private CommonReq common;

    public RequestRecommendMessage() {
        super(CmdConfigHttp.CMD_RECOMMEND_FORUM, 309630);
    }

    public void setCommon(CommonReq commonReq) {
        this.common = commonReq;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.common = this.common;
        if (z) {
            r.bindCommonParamsToProtobufData(builder, true);
        }
        RecommforumReqIdl.Builder builder2 = new RecommforumReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
