package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class r implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q f1362a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.f1362a = qVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar == null) {
            this.f1362a.f1361a.x();
        } else {
            this.f1362a.f1361a.a(eVar, false);
        }
    }
}
