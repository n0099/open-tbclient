package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f839a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FrsImageActivity frsImageActivity) {
        this.f839a = frsImageActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        com.baidu.tieba.model.m mVar;
        ax axVar;
        com.baidu.tieba.model.m mVar2;
        mVar = this.f839a.q;
        if (mVar.getLoadDataMode() == 1) {
            if (((Boolean) obj).booleanValue()) {
                this.f839a.q();
            }
            axVar = this.f839a.n;
            bc b = axVar.b();
            boolean booleanValue = ((Boolean) obj).booleanValue();
            mVar2 = this.f839a.q;
            b.a(booleanValue, mVar2.getErrorString());
        }
    }
}
