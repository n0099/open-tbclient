package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.AddGroup.AddGroupReq;
/* loaded from: classes.dex */
public class v extends n implements com.baidu.tieba.im.coder.g {
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
    private String k = "";

    public v() {
        e(103101);
    }

    public int b() {
        return this.i;
    }

    public void a(int i) {
        this.i = i;
    }

    public String c() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public String d() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public String e() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public String f() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    public void e(String str) {
        this.j = str;
    }

    public String g() {
        return this.e;
    }

    public void f(String str) {
        this.e = str;
    }

    public String h() {
        return this.h;
    }

    public void g(String str) {
        this.h = str;
    }

    public int i() {
        return this.f;
    }

    public void b(int i) {
        this.f = i;
    }

    public int j() {
        return this.g;
    }

    public void c(int i) {
        this.g = i;
    }

    public void h(String str) {
        this.k = str;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return AddGroupReq.AddGroupReqIdl.newBuilder().a(AddGroupReq.DataReq.newBuilder().a(c()).b(d()).c(e()).d(f()).a(com.baidu.adp.lib.f.b.a(g(), 0.0d)).b(i()).c(j()).b(com.baidu.adp.lib.f.b.a(h(), 0.0d)).a(b()).build()).build();
    }
}
