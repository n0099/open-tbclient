package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf extends com.baidu.adp.a.g {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        com.baidu.tieba.model.x xVar;
        bl blVar;
        com.baidu.tieba.model.x xVar2;
        xVar = this.a.o;
        if (xVar.getLoadDataMode() == 1) {
            if (((Boolean) obj).booleanValue()) {
                this.a.k();
            }
            blVar = this.a.l;
            bs f = blVar.f();
            boolean booleanValue = ((Boolean) obj).booleanValue();
            xVar2 = this.a.o;
            f.a(booleanValue, xVar2.getErrorString());
        }
    }
}
