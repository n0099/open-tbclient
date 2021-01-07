package com.baidu.tieba.gift.buyGift;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.GetGiftCommonList.DataReq;
import tbclient.GetGiftCommonList.GetGiftCommonListReqIdl;
/* loaded from: classes9.dex */
public class GetGiftCommonListRequestMessage extends NetMessage {
    private Integer timestamp;

    public GetGiftCommonListRequestMessage() {
        super(1001509, CmdConfigSocket.CMD_GET_GIFT_LIST);
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
            t.b(builder, true);
        }
        GetGiftCommonListReqIdl.Builder builder2 = new GetGiftCommonListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
