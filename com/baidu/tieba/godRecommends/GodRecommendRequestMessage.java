package com.baidu.tieba.godRecommends;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.r;
import tbclient.GetRecommendGod.DataReq;
import tbclient.GetRecommendGod.GetRecommendGodReqIdl;
/* loaded from: classes6.dex */
public class GodRecommendRequestMessage extends NetMessage {
    public String userId;

    public GodRecommendRequestMessage() {
        super(1003375, CmdConfigSocket.CMD_GET_GOD_RECOMMEND);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.user_id = Long.valueOf(com.baidu.adp.lib.g.b.toLong(this.userId, 0L));
        if (z) {
            r.a(builder, true);
        }
        GetRecommendGodReqIdl.Builder builder2 = new GetRecommendGodReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
