package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.UpdateMaskInfo.UpdateMaskInfoReq;
/* loaded from: classes.dex */
public final class bj extends s implements com.baidu.tieba.im.coder.g {
    private int a;
    private int b;
    private String c;

    public bj() {
        e(104102);
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return UpdateMaskInfoReq.UpdateMaskInfoReqIdl.newBuilder().a(UpdateMaskInfoReq.DataReq.newBuilder().a(this.a).b(this.b).a(this.c).build()).build();
    }

    public final int b() {
        return this.a;
    }

    public final void a(int i) {
        this.a = i;
    }

    public final int c() {
        return this.b;
    }

    public final void b(int i) {
        this.b = i;
    }

    public final void a(boolean z) {
        this.b = z ? 1 : 0;
    }

    public final void a(String str) {
        this.c = str;
    }
}
