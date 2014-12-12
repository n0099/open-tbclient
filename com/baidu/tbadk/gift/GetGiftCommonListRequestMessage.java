package com.baidu.tbadk.gift;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.GetGiftCommonList.DataReq;
import tbclient.GetGiftCommonList.GetGiftCommonListReqIdl;
/* loaded from: classes.dex */
public class GetGiftCommonListRequestMessage extends NetMessage {
    private Integer timestamp;

    public GetGiftCommonListRequestMessage() {
        super(CmdConfigHttp.GET_GIFT_LIST, 308001);
    }

    @Deprecated
    public Integer getTimestamp() {
        return this.timestamp;
    }

    @Deprecated
    public void setTimestamp(Integer num) {
        this.timestamp = num;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.timestamp = 0;
        if (z) {
            com.baidu.tbadk.util.h.a(builder, true);
        }
        GetGiftCommonListReqIdl.Builder builder2 = new GetGiftCommonListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
