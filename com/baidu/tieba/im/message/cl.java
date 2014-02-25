package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.QueryGroupCount.QueryGroupCountRes;
/* loaded from: classes.dex */
public class cl extends da implements com.baidu.tieba.im.coder.f {
    private int a;
    private int b;
    private String c;
    private String d;

    public cl() {
        e(103011);
    }

    public String a() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }

    public String b() {
        return this.d;
    }

    public void b(String str) {
        this.d = str;
    }

    public int c() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public int d() {
        return this.b;
    }

    public void b(int i) {
        this.b = i;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        QueryGroupCountRes.QueryGroupCountResIdl parseFrom = QueryGroupCountRes.QueryGroupCountResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!l()) {
            b(parseFrom.getData().getLocalGroupCount());
            a(parseFrom.getData().getUserGroupCount());
            b(parseFrom.getData().getBanner().getPicUrl());
            a(parseFrom.getData().getBanner().getLink());
        }
    }
}
