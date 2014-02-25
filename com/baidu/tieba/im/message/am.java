package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryGroupActivity.QueryGroupActivityReq;
/* loaded from: classes.dex */
public class am extends s implements com.baidu.tieba.im.coder.g {
    private int a;
    private int b;

    public am() {
        e(103015);
    }

    public int b() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public int c() {
        return this.a;
    }

    public void b(int i) {
        this.a = i;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return QueryGroupActivityReq.QueryGroupActivityReqIdl.newBuilder().a(QueryGroupActivityReq.DataReq.newBuilder().a(c()).b(b()).build()).build();
    }
}
