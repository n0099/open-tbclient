package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.CommitInviteMsg.CommitInviteMsgRes;
/* loaded from: classes.dex */
public class bb extends cc implements com.baidu.tieba.im.coder.f {
    private CommitInviteMsgRes.DataRes a;

    public bb() {
        super(205002);
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<o> linkedList, byte[] bArr, int i) {
        CommitInviteMsgRes.CommitInviteMsgResIdl parseFrom = CommitInviteMsgRes.CommitInviteMsgResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!i()) {
            this.a = parseFrom.getData();
        }
    }
}
