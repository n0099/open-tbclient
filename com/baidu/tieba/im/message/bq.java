package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.QueryUserInfos.QueryUserInfosRes;
/* loaded from: classes.dex */
public class bq extends bz implements com.baidu.tieba.im.coder.f {
    private QueryUserInfosRes.DataRes a = null;

    public bq() {
        e(205003);
    }

    public QueryUserInfosRes.DataRes a() {
        return this.a;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<n> linkedList, byte[] bArr, int i) {
        QueryUserInfosRes.QueryUserInfosResIdl parseFrom = QueryUserInfosRes.QueryUserInfosResIdl.parseFrom(bArr);
        c(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!i()) {
            this.a = parseFrom.getData();
        }
    }
}
