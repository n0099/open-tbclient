package com.baidu.tieba.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(EditorToolComponetContainer editorToolComponetContainer, int i) {
        this.a = editorToolComponetContainer;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortool.w wVar;
        wVar = this.a.y;
        wVar.a(this.b, null);
    }
}
