package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.GetPeerInfo.GetPeerInfoRes;
/* loaded from: classes.dex */
public class bm extends bz implements com.baidu.tieba.im.coder.f {
    private int a = 1;

    public boolean a() {
        return this.a != 0;
    }

    public bm() {
        e(205004);
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<n> linkedList, byte[] bArr, int i) {
        GetPeerInfoRes.GetPeerInfoResIdl parseFrom = GetPeerInfoRes.GetPeerInfoResIdl.parseFrom(bArr);
        c(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!i()) {
            this.a = parseFrom.getData().getIsAllowed();
        }
    }
}
