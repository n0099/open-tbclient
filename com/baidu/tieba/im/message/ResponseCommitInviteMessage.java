package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import protobuf.CommitInviteMsg.CommitInviteMsgRes;
/* loaded from: classes.dex */
public class ResponseCommitInviteMessage extends SocketResponsedMessage {
    private CommitInviteMsgRes.DataRes a;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        CommitInviteMsgRes.CommitInviteMsgResIdl parseFrom = CommitInviteMsgRes.CommitInviteMsgResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        d(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            this.a = parseFrom.getData();
        }
    }

    public ResponseCommitInviteMessage() {
        super(205002);
    }

    public ResponseCommitInviteMessage(int i) {
        super(i);
    }
}
