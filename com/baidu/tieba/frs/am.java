package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am extends com.baidu.adp.a.e {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        com.baidu.tieba.model.m mVar;
        ax axVar;
        com.baidu.tieba.model.m mVar2;
        mVar = this.a.q;
        if (mVar.getLoadDataMode() == 1) {
            if (((Boolean) obj).booleanValue()) {
                this.a.q();
            }
            axVar = this.a.n;
            bc b = axVar.b();
            boolean booleanValue = ((Boolean) obj).booleanValue();
            mVar2 = this.a.q;
            b.a(booleanValue, mVar2.getErrorString());
        }
    }
}
