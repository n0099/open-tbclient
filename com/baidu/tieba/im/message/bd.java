package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public final class bd extends bf {
    private int b;
    private String c;
    private String d;

    public bd(int i, String str, String str2) {
        this.b = 0;
        this.c = "";
        this.d = "";
        this.b = i;
        this.c = str;
        this.d = str2;
    }

    @Override // com.baidu.tieba.im.message.bf
    protected final void a(protobuf.k kVar) {
        kVar.e(this.d);
        kVar.d(this.c);
        kVar.b(this.b);
    }
}
