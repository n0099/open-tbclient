package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QuitChatroom.QuitChatroomReq;
/* loaded from: classes.dex */
public final class av extends com.baidu.tbadk.message.websockt.d {
    private int a;
    private int b;
    private int c;

    public av(int i, int i2, int i3) {
        super(106102);
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public final int i() {
        return this.c;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return QuitChatroomReq.QuitChatroomReqIdl.newBuilder().a(QuitChatroomReq.DataReq.newBuilder().a(this.a).b(this.b).build()).build();
    }
}
