package com.baidu.tieba.im.frsgroup;
/* loaded from: classes.dex */
class g implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        com.baidu.tieba.im.model.i iVar;
        iVar = this.a.c;
        if (iVar.h() && z) {
            this.a.a(false);
        } else {
            this.a.i();
        }
    }
}
