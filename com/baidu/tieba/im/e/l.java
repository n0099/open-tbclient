package com.baidu.tieba.im.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.im.b<Boolean> {
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(String str) {
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        boolean e;
        i.d(this.b);
        e = i.e(this.b);
        return Boolean.valueOf(e);
    }
}
