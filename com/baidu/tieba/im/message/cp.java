package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.DelGroupUsers.DelGroupUsersRes;
/* loaded from: classes.dex */
public class cp extends da implements com.baidu.tieba.im.coder.f {
    private String a;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        DelGroupUsersRes.DelGroupUsersResIdl parseFrom = DelGroupUsersRes.DelGroupUsersResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        e(i);
        if (!l()) {
            a(String.valueOf(parseFrom.getData().getGroupId()));
        }
    }
}
