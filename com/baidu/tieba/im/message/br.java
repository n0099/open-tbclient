package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.DelGroupUsers.DelGroupUsersRes;
/* loaded from: classes.dex */
public class br extends bz implements com.baidu.tieba.im.coder.f {
    private String a;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<n> linkedList, byte[] bArr, int i) {
        DelGroupUsersRes.DelGroupUsersResIdl parseFrom = DelGroupUsersRes.DelGroupUsersResIdl.parseFrom(bArr);
        c(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        e(i);
        if (!i()) {
            a(String.valueOf(parseFrom.getData().getGroupId()));
        }
    }
}
