package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.EnterChatroom.EnterChatroomReq;
/* loaded from: classes.dex */
public final class ae extends com.baidu.tbadk.message.websockt.d {
    private long a;

    public ae() {
        super(106101);
    }

    public final void b(long j) {
        this.a = j;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return EnterChatroomReq.EnterChatroomReqIdl.newBuilder().a(EnterChatroomReq.DataReq.newBuilder().a((int) this.a).build()).build();
    }
}
