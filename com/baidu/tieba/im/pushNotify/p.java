package com.baidu.tieba.im.pushNotify;
/* loaded from: classes.dex */
class p extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ o b;
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, String str, String str2) {
        this.b = oVar;
        this.c = str;
        this.d = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        n b = this.b.b(this.c, this.d);
        if (b == null) {
            return false;
        }
        return Boolean.valueOf(b.isAcceptNotify());
    }
}
