package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public final class bh extends bf {
    private String b;

    public bh(String str) {
        this.b = null;
        this.b = str;
    }

    @Override // com.baidu.tieba.im.message.bf
    protected final void a(protobuf.k kVar) {
        kVar.c(this.b);
    }
}
