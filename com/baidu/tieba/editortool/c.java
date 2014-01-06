package com.baidu.tieba.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ t a;
    final /* synthetic */ EditorToolComponetContainer b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(EditorToolComponetContainer editorToolComponetContainer, t tVar) {
        this.b = editorToolComponetContainer;
        this.a = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.b.b.getmFace()) {
            this.a.a(2, null);
        } else if (view == this.b.b.getmImage() || view == this.b.b.getmIVImage()) {
            if (this.b.b.b()) {
                this.a.a(7, null);
            } else if (this.b.b.c()) {
                this.b.w();
            } else {
                this.b.b.setmImagetype(2);
                this.a.a(23, null);
            }
        } else if (view == this.b.b.getmCamera() || view == this.b.b.getmIVCamera()) {
            if (this.b.b.c()) {
                this.a.a(7, null);
            } else if (this.b.b.b()) {
                this.b.x();
            } else {
                this.b.b.setmImagetype(1);
                this.a.a(22, null);
            }
        } else if (view == this.b.b.getmAt()) {
            this.a.a(0, null);
        }
    }
}
