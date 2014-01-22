package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.UpgradeMemberGroup.UpgradeMemberGroupRes;
/* loaded from: classes.dex */
public class cp extends cr implements com.baidu.tieba.im.coder.f {
    public cp() {
        super(103105);
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<q> linkedList, byte[] bArr, int i) {
        UpgradeMemberGroupRes.UpgradeMemberGroupResIdl parseFrom = UpgradeMemberGroupRes.UpgradeMemberGroupResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
    }
}
