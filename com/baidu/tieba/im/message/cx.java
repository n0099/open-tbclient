package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.UpdateMaskInfo.UpdateMaskInfoRes;
/* loaded from: classes.dex */
public class cx extends da implements com.baidu.tieba.im.coder.f {
    public cx() {
        super(104102);
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        UpdateMaskInfoRes.UpdateMaskInfoResIdl parseFrom = UpdateMaskInfoRes.UpdateMaskInfoResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
    }
}
