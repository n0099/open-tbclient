package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.CommitInviteMsg.CommitInviteMsgReq;
/* loaded from: classes.dex */
public final class aa extends com.baidu.tbadk.message.websockt.d {
    private CommitInviteMsgReq.DataReq a;

    public aa() {
        super(205002);
    }

    public final void a(CommitInviteMsgReq.DataReq dataReq) {
        this.a = dataReq;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        if (this.a != null) {
            return CommitInviteMsgReq.CommitInviteMsgReqIdl.newBuilder().a(this.a).build();
        }
        return null;
    }
}
