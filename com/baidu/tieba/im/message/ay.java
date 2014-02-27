package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QuitChatroom.QuitChatroomReq;
/* loaded from: classes.dex */
public final class ay extends s implements com.baidu.tieba.im.coder.g {
    private int a;
    private int b;
    private int c;

    public ay(int i, int i2, int i3) {
        e(106102);
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public final int b() {
        return this.c;
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return QuitChatroomReq.QuitChatroomReqIdl.newBuilder().a(QuitChatroomReq.DataReq.newBuilder().a(this.a).b(this.b).build()).build();
    }
}
