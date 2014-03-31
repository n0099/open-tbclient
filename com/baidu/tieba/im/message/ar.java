package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.GetPeerInfo.GetPeerInfoReq;
/* loaded from: classes.dex */
public final class ar extends com.baidu.tbadk.message.websockt.d {
    private long a;

    public ar() {
        super(205004);
    }

    public final void b(long j) {
        this.a = j;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return GetPeerInfoReq.GetPeerInfoReqIdl.newBuilder().a(GetPeerInfoReq.DataReq.newBuilder().a(this.a).build()).build();
    }
}
