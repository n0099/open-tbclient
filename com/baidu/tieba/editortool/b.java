package com.baidu.tieba.editortool;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements DialogInterface.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer a;
    private final /* synthetic */ z b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(EditorToolComponetContainer editorToolComponetContainer, z zVar) {
        this.a = editorToolComponetContainer;
        this.b = zVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        boolean z;
        z = this.a.m;
        if (z) {
            this.a.b.setmImagetype(2);
            this.b.a(23, null);
            return;
        }
        this.a.b.setmImagetype(1);
        this.b.a(22, null);
    }
}
