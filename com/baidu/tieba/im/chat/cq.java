package com.baidu.tieba.im.chat;

import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cq implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ cp a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(cp cpVar) {
        this.a = cpVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        String a;
        if (bVar != null) {
            cp cpVar = this.a;
            a = this.a.a(str, bVar.k());
            cpVar.a(a);
            return;
        }
        this.a.a(this.a.b.getString(R.string.save_error));
    }
}
