package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends com.baidu.adp.a.e {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        com.baidu.tieba.model.m mVar;
        az azVar;
        com.baidu.tieba.model.m mVar2;
        mVar = this.a.D;
        if (mVar.getLoadDataMode() == 1) {
            if (((Boolean) obj).booleanValue()) {
                this.a.r();
            }
            azVar = this.a.l;
            bc a = azVar.a();
            boolean booleanValue = ((Boolean) obj).booleanValue();
            mVar2 = this.a.D;
            a.a(booleanValue, mVar2.getErrorString());
        }
    }
}
