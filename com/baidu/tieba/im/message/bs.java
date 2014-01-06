package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.QueryGroupCount.QueryGroupCountRes;
/* loaded from: classes.dex */
public class bs extends cc implements com.baidu.tieba.im.coder.f {
    private int a;
    private int b;

    public bs() {
        e(103011);
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public int b() {
        return this.b;
    }

    public void b(int i) {
        this.b = i;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<o> linkedList, byte[] bArr, int i) {
        QueryGroupCountRes.QueryGroupCountResIdl parseFrom = QueryGroupCountRes.QueryGroupCountResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!i()) {
            b(parseFrom.getData().getLocalGroupCount());
            a(parseFrom.getData().getUserGroupCount());
        }
    }
}
