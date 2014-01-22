package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.QueryGroupLocation.QueryGroupLocationRes;
/* loaded from: classes.dex */
public class cj implements com.baidu.tieba.im.coder.f {
    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<q> linkedList, byte[] bArr, int i) {
        QueryGroupLocationRes.QueryGroupLocationResIdl parseFrom = QueryGroupLocationRes.QueryGroupLocationResIdl.parseFrom(bArr);
        QueryGroupLocationRes.DataRes data = parseFrom.getData();
        ci ciVar = new ci(103010);
        ciVar.g(parseFrom.getError().getErrorno());
        ciVar.c(parseFrom.getError().getUsermsg());
        ciVar.a(ciVar.a());
        int businessCount = data.getBusinessCount();
        for (int i2 = 0; i2 < businessCount; i2++) {
            ciVar.b(data.getBusiness(i2));
        }
        linkedList.add(ciVar);
    }
}
