package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.CheckMaskUser.CheckMaskUserRes;
/* loaded from: classes.dex */
public class bo extends da implements com.baidu.tieba.im.coder.f {
    private boolean a;

    public bo() {
        super(104104);
        this.a = false;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        CheckMaskUserRes.CheckMaskUserResIdl parseFrom = CheckMaskUserRes.CheckMaskUserResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!l()) {
            a(parseFrom.getData().getIsMask() == 1);
        }
    }

    public boolean a() {
        return this.a;
    }

    public void a(boolean z) {
        this.a = z;
    }
}
