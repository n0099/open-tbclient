package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.CommitPusherCount.CommitPusherCountRes;
/* loaded from: classes.dex */
public class ck extends da implements com.baidu.tieba.im.coder.f {
    @Override // com.baidu.tieba.im.coder.f
    public final void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        CommitPusherCountRes.CommitPusherCountResIdl parseFrom = CommitPusherCountRes.CommitPusherCountResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        e(i);
        if (l()) {
        }
    }
}
