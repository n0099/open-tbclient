package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.DelGroupUsers.DelGroupUsersReq;
/* loaded from: classes.dex */
public class an extends o implements com.baidu.tieba.im.coder.g {
    private long a;
    private String b;

    public an() {
        e(103112);
    }

    public long b() {
        return this.a;
    }

    public void a(long j) {
        this.a = j;
    }

    public String c() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return DelGroupUsersReq.DelGroupUsersReqIdl.newBuilder().a(DelGroupUsersReq.DataReq.newBuilder().a((int) b()).a(c()).build()).build();
    }
}
