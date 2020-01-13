package com.baidu.tieba.im.recommend.detail;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.Bigvip.BigvipReqIdl;
import tbclient.Bigvip.DataReq;
/* loaded from: classes11.dex */
public class RecommendDetailRequestMessage extends NetMessage {
    private long mUserId;

    public RecommendDetailRequestMessage() {
        super(1001535, CmdConfigSocket.CMD_GET_RECOMMEND_DETAIL);
    }

    public void setUserId(long j) {
        this.mUserId = j;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            t.a(builder, true);
        }
        builder.user_id = Long.valueOf(this.mUserId);
        BigvipReqIdl.Builder builder2 = new BigvipReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
