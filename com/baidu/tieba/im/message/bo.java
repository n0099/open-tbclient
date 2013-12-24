package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.CommitPusherCount.CommitPusherCountRes;
/* loaded from: classes.dex */
public class bo extends bz implements com.baidu.tieba.im.coder.f {
    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<n> linkedList, byte[] bArr, int i) {
        CommitPusherCountRes.CommitPusherCountResIdl parseFrom = CommitPusherCountRes.CommitPusherCountResIdl.parseFrom(bArr);
        c(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        e(i);
        if (i()) {
        }
    }
}
