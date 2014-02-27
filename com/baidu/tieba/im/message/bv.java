package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.DelGroup.DelGroupRes;
/* loaded from: classes.dex */
public class bv extends da implements com.baidu.tieba.im.coder.f {
    private long a;

    public final long a() {
        return this.a;
    }

    @Override // com.baidu.tieba.im.coder.f
    public final void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        DelGroupRes.DelGroupResIdl parseFrom = DelGroupRes.DelGroupResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        e(i);
        linkedList.add(this);
        if (!l()) {
            this.a = parseFrom.getData().getGroupId();
        }
    }
}
