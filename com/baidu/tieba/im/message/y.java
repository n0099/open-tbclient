package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.AddGroup.AddGroupReq;
/* loaded from: classes.dex */
public final class y extends com.baidu.tbadk.message.websockt.d {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private int f;
    private int g;
    private String h;
    private int i;
    private String j;
    private String k;

    public y() {
        super(103101);
        this.k = "";
    }

    public final void d(int i) {
        this.i = i;
    }

    public final String i() {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final void b(String str) {
        this.b = str;
    }

    public final String j() {
        return this.c;
    }

    public final void c(String str) {
        this.c = str;
    }

    public final void d(String str) {
        this.d = str;
    }

    public final void e(String str) {
        this.j = str;
    }

    public final void f(String str) {
        this.e = str;
    }

    public final void g(String str) {
        this.h = str;
    }

    public final int l() {
        return this.f;
    }

    public final void e(int i) {
        this.f = i;
    }

    public final void f(int i) {
        this.g = i;
    }

    public final void h(String str) {
        this.k = str;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return AddGroupReq.AddGroupReqIdl.newBuilder().a(AddGroupReq.DataReq.newBuilder().a(this.a).b(this.b).c(this.c).d(this.d).a(com.baidu.adp.lib.f.b.a(this.e, 0.0d)).b(this.f).c(this.g).b(com.baidu.adp.lib.f.b.a(this.h, 0.0d)).a(this.i).build()).build();
    }
}
