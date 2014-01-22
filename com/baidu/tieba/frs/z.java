package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.adp.a.g {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        com.baidu.tieba.model.x xVar;
        bk bkVar;
        com.baidu.tieba.model.x xVar2;
        xVar = this.a.E;
        if (xVar.getLoadDataMode() == 1) {
            if (((Boolean) obj).booleanValue()) {
                this.a.t();
            }
            bkVar = this.a.n;
            bq f = bkVar.f();
            boolean booleanValue = ((Boolean) obj).booleanValue();
            xVar2 = this.a.E;
            f.a(booleanValue, xVar2.getErrorString());
        }
    }
}
