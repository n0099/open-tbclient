package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class df implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ de a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(de deVar) {
        this.a = deVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar != null) {
            this.a.a(de.a(this.a, str, bVar.k()));
        } else {
            this.a.a(this.a.b.getString(com.baidu.tieba.im.j.save_error));
        }
    }
}
