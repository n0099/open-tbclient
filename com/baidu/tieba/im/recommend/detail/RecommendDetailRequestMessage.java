package com.baidu.tieba.im.recommend.detail;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.j;
import tbclient.Bigvip.BigvipReqIdl;
import tbclient.Bigvip.DataReq;
/* loaded from: classes.dex */
public class RecommendDetailRequestMessage extends NetMessage {
    private int mUserId;

    public RecommendDetailRequestMessage() {
        super(CmdConfigHttp.CMD_GET_RECOMMEND_DETAIL, 303025);
    }

    public void setUserId(int i) {
        this.mUserId = i;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            j.a(builder, true);
        }
        builder.user_id = Integer.valueOf(this.mUserId);
        BigvipReqIdl.Builder builder2 = new BigvipReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
