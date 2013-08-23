package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1077a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(FrsImageActivity frsImageActivity) {
        this.f1077a = frsImageActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        com.baidu.tieba.model.n nVar;
        az azVar;
        com.baidu.tieba.model.n nVar2;
        nVar = this.f1077a.q;
        if (nVar.getLoadDataMode() == 1) {
            if (((Boolean) obj).booleanValue()) {
                this.f1077a.p();
            }
            azVar = this.f1077a.n;
            bh b = azVar.b();
            boolean booleanValue = ((Boolean) obj).booleanValue();
            nVar2 = this.f1077a.q;
            b.a(booleanValue, nVar2.getErrorString());
        }
    }
}
