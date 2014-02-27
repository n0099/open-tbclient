package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public final class bf extends bg {
    private String b;

    public bf(String str) {
        this.b = str;
    }

    @Override // com.baidu.tieba.im.message.bg
    protected final void a(protobuf.k kVar) {
        kVar.b(this.b);
    }
}
