package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.UpdateChatroomTopic.UpdateChatroomTopicRes;
/* loaded from: classes.dex */
public class cm extends cr implements com.baidu.tieba.im.coder.f {
    public cm() {
        e(106103);
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<q> linkedList, byte[] bArr, int i) {
        UpdateChatroomTopicRes.UpdateChatroomTopicResIdl parseFrom = UpdateChatroomTopicRes.UpdateChatroomTopicResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (k()) {
        }
    }
}
