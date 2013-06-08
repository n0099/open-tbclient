package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends com.baidu.adp.a.e {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        com.baidu.tieba.c.j jVar;
        ba baVar;
        com.baidu.tieba.c.j jVar2;
        jVar = this.a.D;
        if (jVar.a() == 1) {
            if (((Boolean) obj).booleanValue()) {
                this.a.r();
            }
            baVar = this.a.l;
            bd a = baVar.a();
            boolean booleanValue = ((Boolean) obj).booleanValue();
            jVar2 = this.a.D;
            a.a(booleanValue, jVar2.c());
        }
    }
}
