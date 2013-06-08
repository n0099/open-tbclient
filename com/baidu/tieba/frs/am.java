package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am extends com.baidu.adp.a.e {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        com.baidu.tieba.c.j jVar;
        ay ayVar;
        com.baidu.tieba.c.j jVar2;
        jVar = this.a.q;
        if (jVar.a() == 1) {
            if (((Boolean) obj).booleanValue()) {
                this.a.q();
            }
            ayVar = this.a.n;
            bd b = ayVar.b();
            boolean booleanValue = ((Boolean) obj).booleanValue();
            jVar2 = this.a.q;
            b.a(booleanValue, jVar2.c());
        }
    }
}
