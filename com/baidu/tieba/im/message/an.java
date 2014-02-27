package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.GetMaskInfo.GetMaskInfoReq;
/* loaded from: classes.dex */
public final class an extends s implements com.baidu.tieba.im.coder.g {
    private int a;

    public an() {
        e(104103);
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return GetMaskInfoReq.GetMaskInfoReqIdl.newBuilder().a(GetMaskInfoReq.DataReq.newBuilder().a(this.a).build()).build();
    }

    public final int b() {
        return this.a;
    }

    public final void a(int i) {
        this.a = i;
    }
}
