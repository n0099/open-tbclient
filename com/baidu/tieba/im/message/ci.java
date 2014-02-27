package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.GetPeerInfo.GetPeerInfoRes;
/* loaded from: classes.dex */
public class ci extends da implements com.baidu.tieba.im.coder.f {
    private int a = 1;

    public final boolean a() {
        return this.a != 0;
    }

    public ci() {
        e(205004);
    }

    @Override // com.baidu.tieba.im.coder.f
    public final void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        GetPeerInfoRes.GetPeerInfoResIdl parseFrom = GetPeerInfoRes.GetPeerInfoResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!l()) {
            this.a = parseFrom.getData().getIsAllowed();
        }
    }
}
