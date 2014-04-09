package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public final class be extends bf {
    private String b;

    public be(String str) {
        this.b = str;
    }

    @Override // com.baidu.tieba.im.message.bf
    protected final void a(protobuf.k kVar) {
        kVar.b(this.b);
    }
}
