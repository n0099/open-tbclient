package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.UpgradeMemberGroup.UpgradeMemberGroupRes;
/* loaded from: classes.dex */
public class cy extends da implements com.baidu.tieba.im.coder.f {
    public cy() {
        super(103105);
    }

    @Override // com.baidu.tieba.im.coder.f
    public final void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        UpgradeMemberGroupRes.UpgradeMemberGroupResIdl parseFrom = UpgradeMemberGroupRes.UpgradeMemberGroupResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
    }
}
