package com.baidu.tieba.im.recommend.detail;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.m0.z0.w;
import tbclient.Bigvip.BigvipReqIdl;
import tbclient.Bigvip.DataReq;
/* loaded from: classes4.dex */
public class RecommendDetailRequestMessage extends NetMessage {
    public long mUserId;

    public RecommendDetailRequestMessage() {
        super(CmdConfigHttp.CMD_GET_RECOMMEND_DETAIL, 303025);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            w.a(builder, true);
        }
        builder.user_id = Long.valueOf(this.mUserId);
        BigvipReqIdl.Builder builder2 = new BigvipReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setUserId(long j) {
        this.mUserId = j;
    }
}
