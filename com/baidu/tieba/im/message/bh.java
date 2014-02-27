package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public final class bh extends bg {
    private String b;

    public bh(String str) {
        this.b = str;
    }

    @Override // com.baidu.tieba.im.message.bg
    protected final void a(protobuf.k kVar) {
        kVar.a(this.b);
    }
}
