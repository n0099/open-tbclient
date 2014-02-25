package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.QueryGroupLocation.QueryGroupLocationRes;
/* loaded from: classes.dex */
public class cs implements com.baidu.tieba.im.coder.f {
    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        QueryGroupLocationRes.QueryGroupLocationResIdl parseFrom = QueryGroupLocationRes.QueryGroupLocationResIdl.parseFrom(bArr);
        QueryGroupLocationRes.DataRes data = parseFrom.getData();
        cr crVar = new cr(103010);
        crVar.g(parseFrom.getError().getErrorno());
        crVar.c(parseFrom.getError().getUsermsg());
        crVar.a(crVar.a());
        int businessCount = data.getBusinessCount();
        for (int i2 = 0; i2 < businessCount; i2++) {
            crVar.b(data.getBusiness(i2));
        }
        linkedList.add(crVar);
    }
}
