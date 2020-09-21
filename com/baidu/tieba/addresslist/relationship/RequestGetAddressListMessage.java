package com.baidu.tieba.addresslist.relationship;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import tbclient.GetAddressList.GetAddressListReqIdl;
import tbclient.GetAddressList.ReqData;
/* loaded from: classes20.dex */
public class RequestGetAddressListMessage extends TbSocketMessage {
    private static final int INIT_TIMESTAMP = 0;
    private int mTimestamp;

    @Deprecated
    public void setTimestamp(int i) {
        this.mTimestamp = i;
    }

    public int getTimestamp() {
        return this.mTimestamp;
    }

    public RequestGetAddressListMessage(int i) {
        super(CmdConfigSocket.CMD_GET_ADDRESSLIST);
        this.mTimestamp = 0;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    protected Object encode() {
        ReqData.Builder builder = new ReqData.Builder();
        builder.timestamp = 0;
        GetAddressListReqIdl.Builder builder2 = new GetAddressListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
