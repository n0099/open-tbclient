package com.baidu.tieba.gift.buyGift;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.i0.z0.w;
import tbclient.GetGiftCommonList.DataReq;
import tbclient.GetGiftCommonList.GetGiftCommonListReqIdl;
/* loaded from: classes4.dex */
public class GetGiftCommonListRequestMessage extends NetMessage {
    public Integer timestamp;

    public GetGiftCommonListRequestMessage() {
        super(CmdConfigHttp.GET_GIFT_LIST, 308001);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.timestamp = 0;
        if (z) {
            w.a(builder, true);
        }
        GetGiftCommonListReqIdl.Builder builder2 = new GetGiftCommonListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    @Deprecated
    public Integer getTimestamp() {
        return this.timestamp;
    }

    @Deprecated
    public void setTimestamp(Integer num) {
        this.timestamp = num;
    }
}
