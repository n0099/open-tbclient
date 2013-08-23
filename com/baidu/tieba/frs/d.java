package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class d implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f1097a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f1097a = cVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        if (bVar == null) {
            frsActivity2 = this.f1097a.f1096a;
            frsActivity2.x();
            return;
        }
        frsActivity = this.f1097a.f1096a;
        frsActivity.a(bVar, false);
    }
}
