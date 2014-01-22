package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.im.message.cr;
import java.util.LinkedList;
import protobuf.DelGroupMsgs.DelGroupMsgsRes;
/* loaded from: classes.dex */
public class ai extends cr implements com.baidu.tieba.im.coder.f {
    private long a;

    public void a(long j) {
        this.a = j;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<com.baidu.tieba.im.message.q> linkedList, byte[] bArr, int i) {
        DelGroupMsgsRes.DelGroupMsgsResIdl parseFrom = DelGroupMsgsRes.DelGroupMsgsResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        e(i);
        linkedList.add(this);
        if (!k()) {
            a(parseFrom.getData().getGroupId());
        }
    }
}
