package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class r implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.a = qVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar == null) {
            this.a.a.x();
        } else {
            this.a.a.a(eVar, false);
        }
    }
}
