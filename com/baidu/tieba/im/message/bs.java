package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.CommitPersonalMsg.CommitPersonalMsgRes;
/* loaded from: classes.dex */
public class bs extends br {
    private String a = null;

    public bs() {
        e(205001);
    }

    public final String d() {
        return this.a;
    }

    @Override // com.baidu.tieba.im.coder.f
    public final void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        CommitPersonalMsgRes.CommitPersonalMsgResIdl parseFrom = CommitPersonalMsgRes.CommitPersonalMsgResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!l()) {
            a(parseFrom.getData().getMsgId() * 100);
            b(parseFrom.getData().getRecordId());
            a(String.valueOf(parseFrom.getData().getGroupId()));
            this.a = String.valueOf(parseFrom.getData().getToUid());
        }
    }
}
