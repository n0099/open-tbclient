package com.baidu.tieba.im.pushNotify;
/* loaded from: classes.dex */
class c extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ b a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, String str, String str2) {
        this.a = bVar;
        this.b = str;
        this.c = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        a b = this.a.b(this.b, this.c);
        if (b == null) {
            return false;
        }
        return Boolean.valueOf(b.isAcceptNotify());
    }
}
