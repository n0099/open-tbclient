package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1107a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.f1107a = frsActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        com.baidu.tieba.model.n nVar;
        bb bbVar;
        com.baidu.tieba.model.n nVar2;
        String str;
        nVar = this.f1107a.D;
        if (nVar.getLoadDataMode() == 1) {
            if (((Boolean) obj).booleanValue()) {
                com.baidu.tieba.model.p a2 = com.baidu.tieba.model.p.a();
                str = this.f1107a.c;
                a2.b(str);
                this.f1107a.t();
            }
            bbVar = this.f1107a.l;
            bh a3 = bbVar.a();
            boolean booleanValue = ((Boolean) obj).booleanValue();
            nVar2 = this.f1107a.D;
            a3.a(booleanValue, nVar2.getErrorString());
        }
    }
}
