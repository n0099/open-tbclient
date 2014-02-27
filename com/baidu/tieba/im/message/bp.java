package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.CommitGroupMsg.CommitGroupMsgRes;
/* loaded from: classes.dex */
public class bp extends br {
    public bp() {
        e(202001);
    }

    @Override // com.baidu.tieba.im.coder.f
    public final void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        CommitGroupMsgRes.CommitGroupMsgResIdl parseFrom = CommitGroupMsgRes.CommitGroupMsgResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!l()) {
            a(parseFrom.getData().getMsgId() * 100);
            b(parseFrom.getData().getRecordId());
            a(String.valueOf(parseFrom.getData().getGroupId()));
        }
    }
}
