package com.baidu.tieba.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer aqU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(EditorToolComponetContainer editorToolComponetContainer) {
        this.aqU = editorToolComponetContainer;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortool.w wVar;
        com.baidu.tbadk.editortool.w wVar2;
        com.baidu.tbadk.editortool.w wVar3;
        com.baidu.tbadk.editortool.w wVar4;
        com.baidu.tbadk.editortool.w wVar5;
        com.baidu.tbadk.editortool.w wVar6;
        com.baidu.tbadk.editortool.w wVar7;
        com.baidu.tbadk.editortool.w wVar8;
        if (view == this.aqU.aqw.getmFace()) {
            wVar8 = this.aqU.RC;
            wVar8.handleAction(2, null);
        } else if (view == this.aqU.aqw.getmImage() || view == this.aqU.aqw.getmIVImage()) {
            this.aqU.aqw.setmImagetype(2);
            wVar = this.aqU.RC;
            wVar.handleAction(23, null);
        } else if (view == this.aqU.aqw.getmCamera() || view == this.aqU.aqw.getmIVCamera()) {
            this.aqU.aqw.setmImagetype(1);
            wVar2 = this.aqU.RC;
            wVar2.handleAction(22, null);
        } else if (view == this.aqU.aqw.getmAt()) {
            wVar7 = this.aqU.RC;
            wVar7.handleAction(0, null);
        } else if (view == this.aqU.aqw.getmPrivilege()) {
            wVar6 = this.aqU.RC;
            wVar6.handleAction(44, null);
        } else if (view == this.aqU.aqw.getBaobao()) {
            wVar5 = this.aqU.RC;
            wVar5.handleAction(48, null);
        } else if (view == this.aqU.aqw.getRecordButton()) {
            wVar4 = this.aqU.RC;
            wVar4.handleAction(4, null);
        } else if (view == this.aqU.aqw.getLocation()) {
            wVar3 = this.aqU.RC;
            wVar3.handleAction(52, null);
        }
    }
}
