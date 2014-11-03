package com.baidu.tieba.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer ard;
    private final /* synthetic */ int arf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(EditorToolComponetContainer editorToolComponetContainer, int i) {
        this.ard = editorToolComponetContainer;
        this.arf = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortool.w wVar;
        wVar = this.ard.RG;
        wVar.handleAction(this.arf, null);
    }
}
