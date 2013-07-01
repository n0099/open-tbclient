package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f866a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.f866a = frsActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        com.baidu.tieba.model.m mVar;
        az azVar;
        com.baidu.tieba.model.m mVar2;
        mVar = this.f866a.D;
        if (mVar.getLoadDataMode() == 1) {
            if (((Boolean) obj).booleanValue()) {
                this.f866a.r();
            }
            azVar = this.f866a.l;
            bc a2 = azVar.a();
            boolean booleanValue = ((Boolean) obj).booleanValue();
            mVar2 = this.f866a.D;
            a2.a(booleanValue, mVar2.getErrorString());
        }
    }
}
