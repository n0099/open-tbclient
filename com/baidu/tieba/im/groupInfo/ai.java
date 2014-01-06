package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.im.message.cc;
import java.util.LinkedList;
import protobuf.DelGroupMsgs.DelGroupMsgsRes;
/* loaded from: classes.dex */
public class ai extends cc implements com.baidu.tieba.im.coder.f {
    private long a;

    public void a(long j) {
        this.a = j;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<com.baidu.tieba.im.message.o> linkedList, byte[] bArr, int i) {
        DelGroupMsgsRes.DelGroupMsgsResIdl parseFrom = DelGroupMsgsRes.DelGroupMsgsResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        e(i);
        linkedList.add(this);
        if (!i()) {
            a(parseFrom.getData().getGroupId());
        }
    }
}
