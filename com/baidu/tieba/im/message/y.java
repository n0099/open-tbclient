package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.DelGroup.DelGroupReq;
/* loaded from: classes.dex */
public class y extends n implements com.baidu.tieba.im.coder.g {
    private int a;

    public y() {
        e(103104);
    }

    public int b() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return DelGroupReq.DelGroupReqIdl.newBuilder().a(DelGroupReq.DataReq.newBuilder().a(b()).build()).build();
    }
}
