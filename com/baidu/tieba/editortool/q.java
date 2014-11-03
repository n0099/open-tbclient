package com.baidu.tieba.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer ard;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(EditorToolComponetContainer editorToolComponetContainer) {
        this.ard = editorToolComponetContainer;
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
        if (view == this.ard.aqF.getmFace()) {
            wVar8 = this.ard.RG;
            wVar8.handleAction(2, null);
        } else if (view == this.ard.aqF.getmImage() || view == this.ard.aqF.getmIVImage()) {
            this.ard.aqF.setmImagetype(2);
            wVar = this.ard.RG;
            wVar.handleAction(23, null);
        } else if (view == this.ard.aqF.getmCamera() || view == this.ard.aqF.getmIVCamera()) {
            this.ard.aqF.setmImagetype(1);
            wVar2 = this.ard.RG;
            wVar2.handleAction(22, null);
        } else if (view == this.ard.aqF.getmAt()) {
            wVar7 = this.ard.RG;
            wVar7.handleAction(0, null);
        } else if (view == this.ard.aqF.getmPrivilege()) {
            wVar6 = this.ard.RG;
            wVar6.handleAction(44, null);
        } else if (view == this.ard.aqF.getBaobao()) {
            wVar5 = this.ard.RG;
            wVar5.handleAction(48, null);
        } else if (view == this.ard.aqF.getRecordButton()) {
            wVar4 = this.ard.RG;
            wVar4.handleAction(4, null);
        } else if (view == this.ard.aqF.getLocation()) {
            wVar3 = this.ard.RG;
            wVar3.handleAction(52, null);
        }
    }
}
