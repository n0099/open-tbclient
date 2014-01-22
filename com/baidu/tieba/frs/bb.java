package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb extends com.baidu.adp.a.g {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        com.baidu.tieba.model.x xVar;
        bi biVar;
        com.baidu.tieba.model.x xVar2;
        xVar = this.a.n;
        if (xVar.getLoadDataMode() == 1) {
            if (((Boolean) obj).booleanValue()) {
                this.a.k();
            }
            biVar = this.a.l;
            bq f = biVar.f();
            boolean booleanValue = ((Boolean) obj).booleanValue();
            xVar2 = this.a.n;
            f.a(booleanValue, xVar2.getErrorString());
        }
    }
}
