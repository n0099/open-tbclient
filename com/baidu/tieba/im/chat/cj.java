package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
final class cj implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ View a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(View view) {
        this.a = view;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        if (dVar != null && this.a != null && (this.a instanceof ViewGroup)) {
            com.baidu.tieba.util.ce.a((ViewGroup) this.a, false, (com.baidu.tieba.util.cg) new ck(this, str, dVar));
        }
    }
}
