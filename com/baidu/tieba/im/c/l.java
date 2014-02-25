package com.baidu.tieba.im.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ j a;
    private final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, boolean z) {
        this.a = jVar;
        this.b = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        a.f().b(this.b && bool.booleanValue(), new m(this));
    }
}
