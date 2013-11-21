package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1313a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FrsActivity frsActivity) {
        this.f1313a = frsActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        com.baidu.tieba.model.x xVar;
        bn bnVar;
        com.baidu.tieba.model.x xVar2;
        String str;
        xVar = this.f1313a.F;
        if (xVar.getLoadDataMode() == 1) {
            if (((Boolean) obj).booleanValue()) {
                com.baidu.tieba.model.z a2 = com.baidu.tieba.model.z.a();
                str = this.f1313a.f;
                a2.b(str);
                this.f1313a.t();
            }
            bnVar = this.f1313a.n;
            bs e = bnVar.e();
            boolean booleanValue = ((Boolean) obj).booleanValue();
            xVar2 = this.f1313a.F;
            e.a(booleanValue, xVar2.getErrorString());
        }
    }
}
