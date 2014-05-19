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
        com.baidu.tieba.im.model.p pVar;
        pVar = this.a.c;
        if (pVar.d() && z) {
            return;
        }
        this.a.h();
    }
}
