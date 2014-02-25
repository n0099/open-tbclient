package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.EnterChatroom.EnterChatroomReq;
/* loaded from: classes.dex */
public class ak extends s implements com.baidu.tieba.im.coder.g {
    private long a;

    public ak() {
        e(106101);
    }

    public void a(long j) {
        this.a = j;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return EnterChatroomReq.EnterChatroomReqIdl.newBuilder().a(EnterChatroomReq.DataReq.newBuilder().a((int) this.a).build()).build();
    }
}
