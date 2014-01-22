package com.baidu.tieba.im.chat;

import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ cg a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cg cgVar) {
        this.a = cgVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        String a;
        if (dVar == null) {
            this.a.a(this.a.b.getString(R.string.save_error));
            return;
        }
        cg cgVar = this.a;
        a = this.a.a(str, dVar.k());
        cgVar.a(a);
    }
}
