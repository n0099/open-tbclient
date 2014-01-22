package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.UpgradeMemberGroup.UpgradeMemberGroupReq;
/* loaded from: classes.dex */
public class be extends q implements com.baidu.tieba.im.coder.g {
    private long a;
    private int b = 1;

    public be() {
        e(103105);
    }

    public long b() {
        return this.a;
    }

    public void a(boolean z) {
        if (z) {
            this.b = 1;
        } else {
            this.b = 0;
        }
    }

    public void a(long j) {
        this.a = j;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return UpgradeMemberGroupReq.UpgradeMemberGroupReqIdl.newBuilder().a(UpgradeMemberGroupReq.DataReq.newBuilder().a((int) this.a).b(this.b).build()).build();
    }
}
