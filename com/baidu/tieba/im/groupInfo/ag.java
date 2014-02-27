package com.baidu.tieba.im.groupInfo;

import com.google.protobuf.MessageLite;
import protobuf.DelGroupMsgs.DelGroupMsgsReq;
/* loaded from: classes.dex */
public final class ag extends com.baidu.tieba.im.message.s implements com.baidu.tieba.im.coder.g {
    private int a;
    private String b;

    public ag() {
        e(202004);
    }

    public final int b() {
        return this.a;
    }

    public final void a(int i) {
        this.a = i;
    }

    public final String c() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return DelGroupMsgsReq.DelGroupMsgsReqIdl.newBuilder().a(DelGroupMsgsReq.DataReq.newBuilder().a(this.a).a(this.b).build()).build();
    }
}
