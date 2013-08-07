package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class d implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f1078a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f1078a = cVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        if (bVar == null) {
            frsActivity2 = this.f1078a.f1077a;
            frsActivity2.t();
            return;
        }
        frsActivity = this.f1078a.f1077a;
        frsActivity.a(bVar, false);
    }
}
