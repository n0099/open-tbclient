package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.QuitChatroom.QuitChatroomRes;
/* loaded from: classes.dex */
public class co extends da implements com.baidu.tieba.im.coder.f {
    public co() {
        e(106102);
    }

    @Override // com.baidu.tieba.im.coder.f
    public final void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        QuitChatroomRes.QuitChatroomResIdl parseFrom = QuitChatroomRes.QuitChatroomResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        e(i);
        linkedList.add(this);
    }
}
