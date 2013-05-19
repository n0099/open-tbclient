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
        com.baidu.tieba.c.g gVar;
        ba baVar;
        com.baidu.tieba.c.g gVar2;
        gVar = this.a.D;
        if (gVar.a() == 1) {
            if (((Boolean) obj).booleanValue()) {
                this.a.r();
            }
            baVar = this.a.l;
            bd a = baVar.a();
            boolean booleanValue = ((Boolean) obj).booleanValue();
            gVar2 = this.a.D;
            a.a(booleanValue, gVar2.c());
        }
    }
}
