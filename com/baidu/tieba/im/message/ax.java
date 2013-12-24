package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.CommitGroupMsg.CommitGroupMsgRes;
/* loaded from: classes.dex */
public class ax extends az {
    public ax() {
        e(202001);
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<n> linkedList, byte[] bArr, int i) {
        CommitGroupMsgRes.CommitGroupMsgResIdl parseFrom = CommitGroupMsgRes.CommitGroupMsgResIdl.parseFrom(bArr);
        c(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!i()) {
            a(com.baidu.tieba.im.chat.ai.b(parseFrom.getData().getMsgId()));
            b(parseFrom.getData().getRecordId());
            a(String.valueOf(parseFrom.getData().getGroupId()));
        }
    }
}
