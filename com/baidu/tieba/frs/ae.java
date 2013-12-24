package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.a.g {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        com.baidu.tieba.model.x xVar;
        bn bnVar;
        com.baidu.tieba.model.x xVar2;
        String str;
        xVar = this.a.F;
        if (xVar.getLoadDataMode() == 1) {
            if (((Boolean) obj).booleanValue()) {
                com.baidu.tieba.model.z a = com.baidu.tieba.model.z.a();
                str = this.a.f;
                a.b(str);
                this.a.t();
            }
            bnVar = this.a.n;
            bs f = bnVar.f();
            boolean booleanValue = ((Boolean) obj).booleanValue();
            xVar2 = this.a.F;
            f.a(booleanValue, xVar2.getErrorString());
        }
    }
}
