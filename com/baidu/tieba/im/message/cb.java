package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.CommitPusherCount.CommitPusherCountRes;
/* loaded from: classes.dex */
public class cb extends cr implements com.baidu.tieba.im.coder.f {
    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<q> linkedList, byte[] bArr, int i) {
        CommitPusherCountRes.CommitPusherCountResIdl parseFrom = CommitPusherCountRes.CommitPusherCountResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        e(i);
        if (k()) {
        }
    }
}
