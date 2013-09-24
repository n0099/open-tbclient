package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1155a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.f1155a = frsActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        com.baidu.tieba.model.p pVar;
        ba baVar;
        com.baidu.tieba.model.p pVar2;
        String str;
        pVar = this.f1155a.F;
        if (pVar.getLoadDataMode() == 1) {
            if (((Boolean) obj).booleanValue()) {
                com.baidu.tieba.model.r a2 = com.baidu.tieba.model.r.a();
                str = this.f1155a.e;
                a2.b(str);
                this.f1155a.w();
            }
            baVar = this.f1155a.o;
            bg a3 = baVar.a();
            boolean booleanValue = ((Boolean) obj).booleanValue();
            pVar2 = this.f1155a.F;
            a3.a(booleanValue, pVar2.getErrorString());
        }
    }
}
