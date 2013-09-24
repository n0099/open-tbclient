package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1124a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(FrsImageActivity frsImageActivity) {
        this.f1124a = frsImageActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        com.baidu.tieba.model.p pVar;
        ay ayVar;
        com.baidu.tieba.model.p pVar2;
        pVar = this.f1124a.p;
        if (pVar.getLoadDataMode() == 1) {
            if (((Boolean) obj).booleanValue()) {
                this.f1124a.q();
            }
            ayVar = this.f1124a.m;
            bg b = ayVar.b();
            boolean booleanValue = ((Boolean) obj).booleanValue();
            pVar2 = this.f1124a.p;
            b.a(booleanValue, pVar2.getErrorString());
        }
    }
}
