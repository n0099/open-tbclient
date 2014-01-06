package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.CheckMaskUser.CheckMaskUserReq;
/* loaded from: classes.dex */
public class z extends o implements com.baidu.tieba.im.coder.g {
    private int a;

    public z() {
        e(104104);
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return CheckMaskUserReq.CheckMaskUserIdl.newBuilder().a(CheckMaskUserReq.DataReq.newBuilder().a(b()).build()).build();
    }

    public int b() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }
}
