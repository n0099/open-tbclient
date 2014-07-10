package com.baidu.tieba.im.live.livelist;
/* loaded from: classes.dex */
class ac implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ z a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar) {
        this.a = zVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        com.baidu.tieba.im.model.n nVar;
        nVar = this.a.c;
        if (nVar.d() && z) {
            return;
        }
        this.a.i();
    }
}
