package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.CommitGroupMsg.CommitGroupMsgRes;
/* loaded from: classes.dex */
public class bj extends bl {
    public bj() {
        e(202001);
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<q> linkedList, byte[] bArr, int i) {
        CommitGroupMsgRes.CommitGroupMsgResIdl parseFrom = CommitGroupMsgRes.CommitGroupMsgResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!k()) {
            a(com.baidu.tieba.im.chat.ba.b(parseFrom.getData().getMsgId()));
            b(parseFrom.getData().getRecordId());
            a(String.valueOf(parseFrom.getData().getGroupId()));
        }
    }
}
