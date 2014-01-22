package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.GetPeerInfo.GetPeerInfoRes;
/* loaded from: classes.dex */
public class bz extends cr implements com.baidu.tieba.im.coder.f {
    private int a = 1;

    public boolean a() {
        return this.a != 0;
    }

    public bz() {
        e(205004);
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<q> linkedList, byte[] bArr, int i) {
        GetPeerInfoRes.GetPeerInfoResIdl parseFrom = GetPeerInfoRes.GetPeerInfoResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!k()) {
            this.a = parseFrom.getData().getIsAllowed();
        }
    }
}
