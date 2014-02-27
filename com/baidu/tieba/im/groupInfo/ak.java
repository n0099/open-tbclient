package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.im.message.da;
import java.util.LinkedList;
import protobuf.ApplyJoinGroup.ApplyJoinGroupRes;
/* loaded from: classes.dex */
public class ak extends da implements com.baidu.tieba.im.coder.f {
    private int a;

    public ak() {
        e(103110);
    }

    @Override // com.baidu.tieba.im.coder.f
    public final void a(LinkedList<com.baidu.tieba.im.message.s> linkedList, byte[] bArr, int i) {
        ApplyJoinGroupRes.ApplyJoinGroupResIdl parseFrom = ApplyJoinGroupRes.ApplyJoinGroupResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!l()) {
            this.a = parseFrom.getData().getGroupId();
        }
    }
}
