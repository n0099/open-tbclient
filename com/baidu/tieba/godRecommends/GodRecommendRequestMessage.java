package com.baidu.tieba.godRecommends;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.r;
import tbclient.GetRecommendGod.DataReq;
import tbclient.GetRecommendGod.GetRecommendGodReqIdl;
/* loaded from: classes6.dex */
public class GodRecommendRequestMessage extends NetMessage {
    public String userId;

    public GodRecommendRequestMessage() {
        super(CmdConfigHttp.CMD_GET_GOD_RECOMMEND, 309471);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.user_id = Long.valueOf(com.baidu.adp.lib.g.b.e(this.userId, 0L));
        if (z) {
            r.bindCommonParamsToProtobufData(builder, true);
        }
        GetRecommendGodReqIdl.Builder builder2 = new GetRecommendGodReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
