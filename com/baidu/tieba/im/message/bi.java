package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public final class bi extends bg {
    private String b;

    public bi(String str) {
        this.b = null;
        this.b = str;
    }

    @Override // com.baidu.tieba.im.message.bg
    protected final void a(protobuf.k kVar) {
        kVar.c(this.b);
    }
}
