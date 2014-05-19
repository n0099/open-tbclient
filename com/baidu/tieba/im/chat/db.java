package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class db implements com.baidu.tbadk.imageManager.d {
    private final /* synthetic */ View a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(View view) {
        this.a = view;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && this.a != null && (this.a instanceof ViewGroup)) {
            com.baidu.tbadk.core.util.bp.a((ViewGroup) this.a, false, (com.baidu.tbadk.core.util.br) new dc(this, str, aVar));
        }
    }
}
