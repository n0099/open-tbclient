package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class d implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f1145a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f1145a = cVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.c cVar, String str, boolean z) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        if (cVar == null) {
            frsActivity2 = this.f1145a.f1144a;
            frsActivity2.A();
            return;
        }
        frsActivity = this.f1145a.f1144a;
        frsActivity.a(cVar, false);
    }
}
