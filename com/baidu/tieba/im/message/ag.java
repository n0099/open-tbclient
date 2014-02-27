package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.CommitInviteMsg.CommitInviteMsgReq;
/* loaded from: classes.dex */
public final class ag extends s implements com.baidu.tieba.im.coder.g {
    private CommitInviteMsgReq.DataReq a;

    public ag() {
        e(205002);
    }

    public final void a(CommitInviteMsgReq.DataReq dataReq) {
        this.a = dataReq;
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        if (this.a != null) {
            return CommitInviteMsgReq.CommitInviteMsgReqIdl.newBuilder().a(this.a).build();
        }
        return null;
    }
}
