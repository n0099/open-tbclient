package com.baidu.tieba.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer a;
    private final /* synthetic */ z b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(EditorToolComponetContainer editorToolComponetContainer, z zVar) {
        this.a = editorToolComponetContainer;
        this.b = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.a.b.getmFace()) {
            this.b.a(2, null);
        } else if (view == this.a.b.getmImage() || view == this.a.b.getmIVImage()) {
            this.a.b.setmImagetype(2);
            this.b.a(23, null);
        } else if (view == this.a.b.getmCamera() || view == this.a.b.getmIVCamera()) {
            this.a.b.setmImagetype(1);
            this.b.a(22, null);
        } else if (view == this.a.b.getmAt()) {
            this.b.a(0, null);
        }
    }
}
