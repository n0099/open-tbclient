package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1332a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(FrsImageActivity frsImageActivity) {
        this.f1332a = frsImageActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        com.baidu.tieba.model.x xVar;
        bl blVar;
        com.baidu.tieba.model.x xVar2;
        xVar = this.f1332a.o;
        if (xVar.getLoadDataMode() == 1) {
            if (((Boolean) obj).booleanValue()) {
                this.f1332a.k();
            }
            blVar = this.f1332a.l;
            bs f = blVar.f();
            boolean booleanValue = ((Boolean) obj).booleanValue();
            xVar2 = this.f1332a.o;
            f.a(booleanValue, xVar2.getErrorString());
        }
    }
}
