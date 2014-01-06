package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class q implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.a = pVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        if (dVar == null) {
            this.a.a.y();
        } else {
            this.a.a.a(dVar, false);
        }
    }
}
