package com.baidu.tieba.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n implements View.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(EditorToolComponetContainer editorToolComponetContainer) {
        this.a = editorToolComponetContainer;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.baidu.tbadk.editortool.x xVar;
        xVar = this.a.t;
        xVar.a(7, null);
    }
}
