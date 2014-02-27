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

    public final String a() {
        return this.c;
    }

    public final String b() {
        return this.d;
    }

    public final int c() {
        return this.a;
    }

    public final int d() {
        return this.b;
    }

    @Override // com.baidu.tieba.im.coder.f
    public final void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        QueryGroupCountRes.QueryGroupCountResIdl parseFrom = QueryGroupCountRes.QueryGroupCountResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!l()) {
            this.b = parseFrom.getData().getLocalGroupCount();
            this.a = parseFrom.getData().getUserGroupCount();
            this.d = parseFrom.getData().getBanner().getPicUrl();
            this.c = parseFrom.getData().getBanner().getLink();
        }
    }
}
