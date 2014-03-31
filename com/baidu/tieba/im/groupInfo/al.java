package com.baidu.tieba.im.groupInfo;

import com.google.protobuf.MessageLite;
import protobuf.DelGroupMsgs.DelGroupMsgsReq;
/* loaded from: classes.dex */
public final class al extends com.baidu.tbadk.message.websockt.d {
    private int a;
    private String b;

    public al() {
        super(202004);
    }

    public final int i() {
        return this.a;
    }

    public final void d(int i) {
        this.a = i;
    }

    public final String j() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return DelGroupMsgsReq.DelGroupMsgsReqIdl.newBuilder().a(DelGroupMsgsReq.DataReq.newBuilder().a(this.a).a(this.b).build()).build();
    }
}
