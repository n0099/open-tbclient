package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.GetPeerInfo.DataReq;
import protobuf.GetPeerInfo.GetPeerInfoReqIdl;
/* loaded from: classes.dex */
public class RequestPeerInfo extends TbSocketMessage {
    private long uid;

    public RequestPeerInfo() {
        super(MessageTypes.CMD_GET_PEER_INFO);
    }

    public long getUid() {
        return this.uid;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.peerUid = Long.valueOf(this.uid);
        GetPeerInfoReqIdl.Builder builder2 = new GetPeerInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
