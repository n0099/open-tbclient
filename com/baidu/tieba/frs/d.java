package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class d implements com.baidu.tbadk.a.d {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        if (bVar == null) {
            frsActivity2 = this.a.a;
            frsActivity2.v();
            return;
        }
        frsActivity = this.a.a;
        frsActivity.a(bVar, false);
    }
}
