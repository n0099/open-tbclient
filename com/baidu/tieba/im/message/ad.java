package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.CommitInviteMsg.CommitInviteMsgReq;
/* loaded from: classes.dex */
public class ad extends q implements com.baidu.tieba.im.coder.g {
    private CommitInviteMsgReq.DataReq a;

    public ad() {
        e(205002);
    }

    public void a(CommitInviteMsgReq.DataReq dataReq) {
        this.a = dataReq;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        if (this.a != null) {
            return CommitInviteMsgReq.CommitInviteMsgReqIdl.newBuilder().a(this.a).build();
        }
        return null;
    }
}
