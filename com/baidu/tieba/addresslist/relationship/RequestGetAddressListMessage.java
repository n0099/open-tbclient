package com.baidu.tieba.addresslist.relationship;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import tbclient.GetAddressList.GetAddressListReqIdl;
import tbclient.GetAddressList.ReqData;
/* loaded from: classes4.dex */
public class RequestGetAddressListMessage extends TbSocketMessage {
    public static final int INIT_TIMESTAMP = 0;
    public int mTimestamp;

    public RequestGetAddressListMessage(int i2) {
        super(304001);
        this.mTimestamp = 0;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        ReqData.Builder builder = new ReqData.Builder();
        builder.timestamp = 0;
        GetAddressListReqIdl.Builder builder2 = new GetAddressListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getTimestamp() {
        return this.mTimestamp;
    }

    @Deprecated
    public void setTimestamp(int i2) {
        this.mTimestamp = i2;
    }
}
