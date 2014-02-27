package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public final class bd extends bg {
    private String b;

    public bd(String str) {
        this.b = null;
        this.b = str;
    }

    @Override // com.baidu.tieba.im.message.bg
    protected final void a(protobuf.k kVar) {
        kVar.f(this.b);
    }
}
