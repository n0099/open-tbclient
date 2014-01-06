package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.QueryGroupLocation.QueryGroupLocationRes;
/* loaded from: classes.dex */
public class bx implements com.baidu.tieba.im.coder.f {
    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<o> linkedList, byte[] bArr, int i) {
        QueryGroupLocationRes.QueryGroupLocationResIdl parseFrom = QueryGroupLocationRes.QueryGroupLocationResIdl.parseFrom(bArr);
        QueryGroupLocationRes.DataRes data = parseFrom.getData();
        bw bwVar = new bw(103010);
        bwVar.g(parseFrom.getError().getErrorno());
        bwVar.c(parseFrom.getError().getUsermsg());
        bwVar.a(bwVar.a());
        int businessCount = data.getBusinessCount();
        for (int i2 = 0; i2 < businessCount; i2++) {
            bwVar.b(data.getBusiness(i2));
        }
        linkedList.add(bwVar);
    }
}
