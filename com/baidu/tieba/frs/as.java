package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1262a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(FrsImageActivity frsImageActivity) {
        this.f1262a = frsImageActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        com.baidu.tieba.model.x xVar;
        ay ayVar;
        com.baidu.tieba.model.x xVar2;
        xVar = this.f1262a.p;
        if (xVar.getLoadDataMode() == 1) {
            if (((Boolean) obj).booleanValue()) {
                this.f1262a.q();
            }
            ayVar = this.f1262a.m;
            bh b = ayVar.b();
            boolean booleanValue = ((Boolean) obj).booleanValue();
            xVar2 = this.f1262a.p;
            b.a(booleanValue, xVar2.getErrorString());
        }
    }
}
