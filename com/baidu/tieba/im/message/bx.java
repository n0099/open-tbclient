package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.UpdateMaskInfo.UpdateMaskInfoRes;
/* loaded from: classes.dex */
public class bx extends bz implements com.baidu.tieba.im.coder.f {
    public bx() {
        super(104102);
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<n> linkedList, byte[] bArr, int i) {
        UpdateMaskInfoRes.UpdateMaskInfoResIdl parseFrom = UpdateMaskInfoRes.UpdateMaskInfoResIdl.parseFrom(bArr);
        c(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
    }
}
