package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.QueryGroupLocation.QueryGroupLocationRes;
/* loaded from: classes.dex */
public class bu implements com.baidu.tieba.im.coder.f {
    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<n> linkedList, byte[] bArr, int i) {
        QueryGroupLocationRes.QueryGroupLocationResIdl parseFrom = QueryGroupLocationRes.QueryGroupLocationResIdl.parseFrom(bArr);
        QueryGroupLocationRes.DataRes data = parseFrom.getData();
        bt btVar = new bt(103010);
        btVar.c(parseFrom.getError().getErrorno());
        btVar.c(parseFrom.getError().getUsermsg());
        btVar.a(btVar.a());
        int businessCount = data.getBusinessCount();
        for (int i2 = 0; i2 < businessCount; i2++) {
            btVar.b(data.getBusiness(i2));
        }
        linkedList.add(btVar);
    }
}
