package com.baidu.tieba.im.groupInfo;

import com.google.protobuf.MessageLite;
import protobuf.DelGroupMsgs.DelGroupMsgsReq;
/* loaded from: classes.dex */
public class af extends com.baidu.tieba.im.message.o implements com.baidu.tieba.im.coder.g {
    private int a;
    private String b;

    public af() {
        e(202004);
    }

    public int b() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public String c() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return DelGroupMsgsReq.DelGroupMsgsReqIdl.newBuilder().a(DelGroupMsgsReq.DataReq.newBuilder().a(b()).a(c()).build()).build();
    }
}
