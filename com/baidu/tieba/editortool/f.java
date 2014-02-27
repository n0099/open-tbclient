package com.baidu.tieba.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f implements View.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EditorToolComponetContainer editorToolComponetContainer) {
        this.a = editorToolComponetContainer;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        aa aaVar;
        aaVar = this.a.r;
        aaVar.a(7, null);
    }
}
