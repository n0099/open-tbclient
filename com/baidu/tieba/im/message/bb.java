package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.DelGroup.DelGroupRes;
/* loaded from: classes.dex */
public class bb extends bz implements com.baidu.tieba.im.coder.f {
    private long a;

    public long a() {
        return this.a;
    }

    public void a(long j) {
        this.a = j;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<n> linkedList, byte[] bArr, int i) {
        DelGroupRes.DelGroupResIdl parseFrom = DelGroupRes.DelGroupResIdl.parseFrom(bArr);
        c(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        e(i);
        linkedList.add(this);
        if (!i()) {
            a(parseFrom.getData().getGroupId());
        }
    }
}
