package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class p implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f1292a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.f1292a = oVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar == null) {
            this.f1292a.f1291a.z();
        } else {
            this.f1292a.f1291a.a(eVar, false);
        }
    }
}
