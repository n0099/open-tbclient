package com.baidu.tieba.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EditorToolComponetContainer editorToolComponetContainer) {
        this.a = editorToolComponetContainer;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        zVar = this.a.r;
        zVar.a(7, null);
    }
}
