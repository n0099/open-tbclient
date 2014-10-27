package com.baidu.tbadk.online;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.GetOnlineInfo.DataReq;
import protobuf.GetOnlineInfo.GetOnlineInfoReqIdl;
/* loaded from: classes.dex */
public class GeOnLineInfoReqMessage extends TbSocketMessage {
    public GeOnLineInfoReqMessage() {
        super(205005);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    protected Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        GetOnlineInfoReqIdl.Builder builder2 = new GetOnlineInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
