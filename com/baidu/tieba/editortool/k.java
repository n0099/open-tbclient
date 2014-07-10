package com.baidu.tieba.editortool;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements DialogInterface.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(EditorToolComponetContainer editorToolComponetContainer) {
        this.a = editorToolComponetContainer;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tbadk.editortool.w wVar;
        this.a.b.setmImagetype(2);
        wVar = this.a.y;
        wVar.a(23, null);
    }
}
