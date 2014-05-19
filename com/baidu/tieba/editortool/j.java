package com.baidu.tieba.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(EditorToolComponetContainer editorToolComponetContainer) {
        this.a = editorToolComponetContainer;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortool.x xVar;
        com.baidu.tbadk.editortool.x xVar2;
        com.baidu.tbadk.editortool.x xVar3;
        com.baidu.tbadk.editortool.x xVar4;
        com.baidu.tbadk.editortool.x xVar5;
        if (view == this.a.b.getmFace()) {
            xVar5 = this.a.t;
            xVar5.a(2, null);
        } else if (view == this.a.b.getmImage() || view == this.a.b.getmIVImage()) {
            this.a.b.setmImagetype(2);
            xVar = this.a.t;
            xVar.a(23, null);
        } else if (view == this.a.b.getmCamera() || view == this.a.b.getmIVCamera()) {
            this.a.b.setmImagetype(1);
            xVar2 = this.a.t;
            xVar2.a(22, null);
        } else if (view == this.a.b.getmAt()) {
            xVar4 = this.a.t;
            xVar4.a(0, null);
        } else if (view == this.a.b.getmPrivilege()) {
            xVar3 = this.a.t;
            xVar3.a(44, null);
        }
    }
}
