package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.CommitPersonalMsg.CommitPersonalMsgRes;
/* loaded from: classes.dex */
public class ba extends az {
    private String a = null;

    public ba() {
        e(205001);
    }

    public String d() {
        return this.a;
    }

    public void b(String str) {
        this.a = str;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<n> linkedList, byte[] bArr, int i) {
        CommitPersonalMsgRes.CommitPersonalMsgResIdl parseFrom = CommitPersonalMsgRes.CommitPersonalMsgResIdl.parseFrom(bArr);
        c(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!i()) {
            a(com.baidu.tieba.im.chat.ai.b(parseFrom.getData().getMsgId()));
            b(parseFrom.getData().getRecordId());
            a(String.valueOf(parseFrom.getData().getGroupId()));
            b(String.valueOf(parseFrom.getData().getToUid()));
        }
    }
}
