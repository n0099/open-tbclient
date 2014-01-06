package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.im.message.cc;
import java.util.LinkedList;
import protobuf.ApplyJoinGroup.ApplyJoinGroupRes;
/* loaded from: classes.dex */
public class aj extends cc implements com.baidu.tieba.im.coder.f {
    private int a;

    public aj() {
        e(103110);
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<com.baidu.tieba.im.message.o> linkedList, byte[] bArr, int i) {
        ApplyJoinGroupRes.ApplyJoinGroupResIdl parseFrom = ApplyJoinGroupRes.ApplyJoinGroupResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!i()) {
            this.a = parseFrom.getData().getGroupId();
        }
    }
}
