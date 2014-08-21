package com.baidu.tieba.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EditorToolComponetContainer editorToolComponetContainer) {
        this.a = editorToolComponetContainer;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortool.w wVar;
        com.baidu.tbadk.editortool.w wVar2;
        com.baidu.tbadk.editortool.w wVar3;
        com.baidu.tbadk.editortool.w wVar4;
        com.baidu.tbadk.editortool.w wVar5;
        com.baidu.tbadk.editortool.w wVar6;
        if (view == this.a.b.getmFace()) {
            wVar6 = this.a.x;
            wVar6.a(2, null);
        } else if (view == this.a.b.getmImage() || view == this.a.b.getmIVImage()) {
            this.a.b.setmImagetype(2);
            wVar = this.a.x;
            wVar.a(23, null);
        } else if (view == this.a.b.getmCamera() || view == this.a.b.getmIVCamera()) {
            this.a.b.setmImagetype(1);
            wVar2 = this.a.x;
            wVar2.a(22, null);
        } else if (view == this.a.b.getmAt()) {
            wVar5 = this.a.x;
            wVar5.a(0, null);
        } else if (view == this.a.b.getmPrivilege()) {
            wVar4 = this.a.x;
            wVar4.a(44, null);
        } else if (view == this.a.b.getBaobao()) {
            wVar3 = this.a.x;
            wVar3.a(48, null);
        }
    }
}
