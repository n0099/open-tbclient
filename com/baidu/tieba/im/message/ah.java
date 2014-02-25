package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.AddGroupActivity.AddGroupActivityReq;
/* loaded from: classes.dex */
public class ah extends s implements com.baidu.tieba.im.coder.g {
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

    public int b() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public int c() {
        return this.b;
    }

    public void b(int i) {
        this.b = i;
    }

    public String d() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }

    public String e() {
        return this.d;
    }

    public void b(String str) {
        this.d = str;
    }

    public String f() {
        return this.e;
    }

    public void c(String str) {
        this.e = str;
    }

    public long g() {
        return this.f;
    }

    public void a(long j) {
        this.f = j;
    }

    public int h() {
        return this.g;
    }

    public void c(int i) {
        this.g = i;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return AddGroupActivityReq.AddGroupActivityReqIdl.newBuilder().a(AddGroupActivityReq.DataReq.newBuilder().b(c()).c(h()).c(f()).b(e()).a(g()).a(d()).a(b()).build()).build();
    }
}
