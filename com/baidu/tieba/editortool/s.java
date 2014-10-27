package com.baidu.tieba.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer aqU;
    private final /* synthetic */ int aqW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(EditorToolComponetContainer editorToolComponetContainer, int i) {
        this.aqU = editorToolComponetContainer;
        this.aqW = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortool.w wVar;
        wVar = this.aqU.RC;
        wVar.handleAction(this.aqW, null);
    }
}
