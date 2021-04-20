package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import d.b.c.c.e.c.a;
import protobuf.CommitReceivedPmsg.CommitReceivedPmsgReqIdl;
import protobuf.CommitReceivedPmsg.DataReq;
/* loaded from: classes4.dex */
public class RequestPersonalMsgReadMessage extends TbSocketMessage implements a {
    public long hasSentMsgId;
    public long toUid;

    public RequestPersonalMsgReadMessage(long j, long j2) {
        super(205006);
        this.hasSentMsgId = j;
        this.toUid = j2;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.groupId = d.b.i0.e1.s.a.i;
            builder.msgType = 22;
            builder.msgId = Long.valueOf(this.hasSentMsgId);
            builder.toUid = Long.valueOf(this.toUid);
            builder.toUserType = 0;
            CommitReceivedPmsgReqIdl.Builder builder2 = new CommitReceivedPmsgReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // d.b.c.c.e.c.a
    public boolean onFindMessage(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof RequestPersonalMsgReadMessage)) {
            RequestPersonalMsgReadMessage requestPersonalMsgReadMessage = (RequestPersonalMsgReadMessage) socketMessage;
            return requestPersonalMsgReadMessage.hasSentMsgId == this.hasSentMsgId && requestPersonalMsgReadMessage.toUid == this.toUid;
        }
        return false;
    }
}
