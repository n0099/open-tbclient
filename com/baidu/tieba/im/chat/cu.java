package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cu implements com.baidu.tbadk.imageManager.d {
    private final /* synthetic */ View a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(View view) {
        this.a = view;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar != null && this.a != null && (this.a instanceof ViewGroup)) {
            com.baidu.tieba.util.ch.a((ViewGroup) this.a, false, (com.baidu.tieba.util.cj) new cv(this, str, bVar));
        }
    }
}
