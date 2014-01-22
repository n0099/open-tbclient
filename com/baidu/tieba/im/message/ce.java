package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.QueryUserInfos.QueryUserInfosRes;
/* loaded from: classes.dex */
public class ce extends cr implements com.baidu.tieba.im.coder.f {
    private QueryUserInfosRes.DataRes a = null;

    public ce() {
        e(205003);
    }

    public QueryUserInfosRes.DataRes a() {
        return this.a;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<q> linkedList, byte[] bArr, int i) {
        QueryUserInfosRes.QueryUserInfosResIdl parseFrom = QueryUserInfosRes.QueryUserInfosResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!k()) {
            this.a = parseFrom.getData();
        }
    }
}
