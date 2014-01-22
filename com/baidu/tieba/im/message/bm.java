package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.CommitPersonalMsg.CommitPersonalMsgRes;
/* loaded from: classes.dex */
public class bm extends bl {
    private String a = null;

    public bm() {
        e(205001);
    }

    public String d() {
        return this.a;
    }

    public void b(String str) {
        this.a = str;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<q> linkedList, byte[] bArr, int i) {
        CommitPersonalMsgRes.CommitPersonalMsgResIdl parseFrom = CommitPersonalMsgRes.CommitPersonalMsgResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!k()) {
            a(com.baidu.tieba.im.chat.ba.b(parseFrom.getData().getMsgId()));
            b(parseFrom.getData().getRecordId());
            a(String.valueOf(parseFrom.getData().getGroupId()));
            b(String.valueOf(parseFrom.getData().getToUid()));
        }
    }
}
