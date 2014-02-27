package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.AddGroupActivity.AddGroupActivityReq;
/* loaded from: classes.dex */
public final class ah extends s implements com.baidu.tieba.im.coder.g {
    private int a;
    private int b;
    private String c;
    private String d;
    private String e;
    private long f;
    private int g;

    public ah() {
        e(103120);
    }

    public final void a(int i) {
        this.a = i;
    }

    public final void b(int i) {
        this.b = i;
    }

    public final void a(String str) {
        this.c = str;
    }

    public final void b(String str) {
        this.d = str;
    }

    public final void c(String str) {
        this.e = str;
    }

    public final void a(long j) {
        this.f = j;
    }

    public final void c(int i) {
        this.g = i;
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return AddGroupActivityReq.AddGroupActivityReqIdl.newBuilder().a(AddGroupActivityReq.DataReq.newBuilder().b(this.b).c(this.g).c(this.e).b(this.d).a(this.f).a(this.c).a(this.a).build()).build();
    }
}
