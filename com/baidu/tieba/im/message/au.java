package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.GetPeerInfo.GetPeerInfoReq;
/* loaded from: classes.dex */
public class au extends s implements com.baidu.tieba.im.coder.g {
    private long a;

    public au() {
        e(205004);
    }

    public void a(long j) {
        this.a = j;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return GetPeerInfoReq.GetPeerInfoReqIdl.newBuilder().a(GetPeerInfoReq.DataReq.newBuilder().a(this.a).build()).build();
    }
}
