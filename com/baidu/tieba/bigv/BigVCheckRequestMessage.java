package com.baidu.tieba.bigv;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.o;
import tbclient.GetVUserInfo.DataReq;
import tbclient.GetVUserInfo.GetVUserInfoReqIdl;
/* loaded from: classes.dex */
public class BigVCheckRequestMessage extends NetMessage {
    private long mUserId;

    public long getUserId() {
        return this.mUserId;
    }

    public void setUserId(long j) {
        this.mUserId = j;
    }

    public BigVCheckRequestMessage() {
        super(CmdConfigHttp.CMD_CHECK_BIG_V, 309463);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.user_id = Long.valueOf(this.mUserId);
            if (z) {
                o.bindCommonParamsToProtobufData(builder, true);
            }
            GetVUserInfoReqIdl.Builder builder2 = new GetVUserInfoReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
