package com.baidu.tieba.editortool;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements DialogInterface.OnClickListener {
    final /* synthetic */ t a;
    final /* synthetic */ EditorToolComponetContainer b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(EditorToolComponetContainer editorToolComponetContainer, t tVar) {
        this.b = editorToolComponetContainer;
        this.a = tVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        boolean z;
        z = this.b.j;
        if (z) {
            this.b.b.setmImagetype(2);
            this.a.a(23, null);
            return;
        }
        this.b.b.setmImagetype(1);
        this.a.a(22, null);
    }
}
