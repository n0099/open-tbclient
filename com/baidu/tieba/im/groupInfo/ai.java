package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.im.message.da;
import java.util.LinkedList;
import protobuf.AddGroupUsers.AddGroupUsersRes;
/* loaded from: classes.dex */
public class ai extends da implements com.baidu.tieba.im.coder.f {
    private int a;

    public ai() {
        e(103111);
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<com.baidu.tieba.im.message.s> linkedList, byte[] bArr, int i) {
        AddGroupUsersRes.AddGroupUsersResIdl parseFrom = AddGroupUsersRes.AddGroupUsersResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!l()) {
            this.a = parseFrom.getData().getGroupId();
        }
    }
}
