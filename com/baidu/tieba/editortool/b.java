package com.baidu.tieba.editortool;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements DialogInterface.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer a;
    private final /* synthetic */ aa b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(EditorToolComponetContainer editorToolComponetContainer, aa aaVar) {
        this.a = editorToolComponetContainer;
        this.b = aaVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
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
