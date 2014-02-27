package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.CheckMaskUser.CheckMaskUserReq;
/* loaded from: classes.dex */
public final class af extends s implements com.baidu.tieba.im.coder.g {
    private int a;

    public af() {
        e(104104);
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return CheckMaskUserReq.CheckMaskUserIdl.newBuilder().a(CheckMaskUserReq.DataReq.newBuilder().a(this.a).build()).build();
    }

    public final void a(int i) {
        this.a = i;
    }
}
