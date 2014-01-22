package com.baidu.tieba.im.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ boolean a;
    final /* synthetic */ m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, boolean z) {
        this.b = mVar;
        this.a = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        a.h().b(this.a && bool.booleanValue(), new p(this));
    }
}
