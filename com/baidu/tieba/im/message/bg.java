package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public final class bg extends bf {
    private String b;

    public bg(String str) {
        this.b = str;
    }

    @Override // com.baidu.tieba.im.message.bf
    protected final void a(protobuf.k kVar) {
        kVar.a(this.b);
    }
}
