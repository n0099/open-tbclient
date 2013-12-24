package com.baidu.tieba.im.groupInfo;

import com.google.protobuf.MessageLite;
import protobuf.AddGroupUsers.AddGroupUsersReq;
/* loaded from: classes.dex */
public class ae extends com.baidu.tieba.im.message.n implements com.baidu.tieba.im.coder.g {
    private int a;
    private String b;
    private String c;
    private int d;
    private String e;
    private int f;
    private long g;
    private int h;

    public ae() {
        e(103111);
    }

    public long b() {
        return this.g;
    }

    public void a(long j) {
        this.g = j;
    }

    public int c() {
        return this.h;
    }

    public void a(int i) {
        this.h = i;
    }

    public int d() {
        return this.a;
    }

    public void b(int i) {
        this.a = i;
    }

    public String e() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public String f() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }

    public int g() {
        return this.d;
    }

    public void c(int i) {
        this.d = i;
    }

    public String h() {
        return this.e;
    }

    public void c(String str) {
        this.e = str;
    }

    public int i() {
        return this.f;
    }

    public void d(int i) {
        this.f = i;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return AddGroupUsersReq.AddGroupUsersReqIdl.newBuilder().a(AddGroupUsersReq.DataReq.newBuilder().d(i()).a(d()).a(b()).e(c()).c(g()).a(e()).build()).build();
    }
}
