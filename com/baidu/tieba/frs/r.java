package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class r implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q f1367a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.f1367a = qVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar == null) {
            this.f1367a.f1366a.x();
        } else {
            this.f1367a.f1366a.a(eVar, false);
        }
    }
}
