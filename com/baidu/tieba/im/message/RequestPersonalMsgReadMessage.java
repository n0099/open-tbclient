package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.CommitReceivedPmsg.CommitReceivedPmsgReqIdl;
import protobuf.CommitReceivedPmsg.DataReq;
/* loaded from: classes.dex */
public class RequestPersonalMsgReadMessage extends TbSocketMessage implements com.baidu.adp.framework.client.socket.a {
    private long hasSentMsgId;
    private long toUid;

    public RequestPersonalMsgReadMessage(long j, long j2) {
        super(205006);
        this.hasSentMsgId = j;
        this.toUid = j2;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    protected Object encode() {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.groupId = com.baidu.tieba.im.sendmessage.a.eBq;
            builder.msgType = 22;
            builder.msgId = Long.valueOf(this.hasSentMsgId);
            builder.toUid = Long.valueOf(this.toUid);
            builder.toUserType = 0;
            CommitReceivedPmsgReqIdl.Builder builder2 = new CommitReceivedPmsgReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.baidu.adp.framework.client.socket.a
    public boolean onFindMessage(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof RequestPersonalMsgReadMessage)) {
            RequestPersonalMsgReadMessage requestPersonalMsgReadMessage = (RequestPersonalMsgReadMessage) socketMessage;
            return requestPersonalMsgReadMessage.hasSentMsgId == this.hasSentMsgId && requestPersonalMsgReadMessage.toUid == this.toUid;
        }
        return false;
    }
}
