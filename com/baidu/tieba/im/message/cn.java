package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.QueryUserInfos.QueryUserInfosRes;
/* loaded from: classes.dex */
public class cn extends da implements com.baidu.tieba.im.coder.f {
    private QueryUserInfosRes.DataRes a = null;

    public cn() {
        e(205003);
    }

    public QueryUserInfosRes.DataRes a() {
        return this.a;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        QueryUserInfosRes.QueryUserInfosResIdl parseFrom = QueryUserInfosRes.QueryUserInfosResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!l()) {
            this.a = parseFrom.getData();
        }
    }
}
