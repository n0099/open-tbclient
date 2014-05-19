package com.baidu.tieba.im.pushNotify;
/* loaded from: classes.dex */
class o extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ n b;
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, String str, String str2) {
        this.b = nVar;
        this.c = str;
        this.d = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        m b = this.b.b(this.c, this.d);
        if (b == null) {
            return false;
        }
        return Boolean.valueOf(b.isAcceptNotify());
    }
}
