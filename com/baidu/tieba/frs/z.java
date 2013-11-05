package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1302a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsActivity frsActivity) {
        this.f1302a = frsActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        com.baidu.tieba.model.x xVar;
        ba baVar;
        com.baidu.tieba.model.x xVar2;
        String str;
        xVar = this.f1302a.F;
        if (xVar.getLoadDataMode() == 1) {
            if (((Boolean) obj).booleanValue()) {
                com.baidu.tieba.model.z a2 = com.baidu.tieba.model.z.a();
                str = this.f1302a.e;
                a2.b(str);
                this.f1302a.v();
            }
            baVar = this.f1302a.o;
            bh a3 = baVar.a();
            boolean booleanValue = ((Boolean) obj).booleanValue();
            xVar2 = this.f1302a.F;
            a3.a(booleanValue, xVar2.getErrorString());
        }
    }
}
