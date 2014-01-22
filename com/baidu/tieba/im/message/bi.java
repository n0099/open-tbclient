package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.CheckMaskUser.CheckMaskUserRes;
/* loaded from: classes.dex */
public class bi extends cr implements com.baidu.tieba.im.coder.f {
    private boolean a;

    public bi() {
        super(104104);
        this.a = false;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<q> linkedList, byte[] bArr, int i) {
        CheckMaskUserRes.CheckMaskUserResIdl parseFrom = CheckMaskUserRes.CheckMaskUserResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!k()) {
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
