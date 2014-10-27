package com.baidu.tieba.editortool;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements DialogInterface.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer aqU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(EditorToolComponetContainer editorToolComponetContainer) {
        this.aqU = editorToolComponetContainer;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tbadk.editortool.w wVar;
        this.aqU.aqw.setmImagetype(2);
        wVar = this.aqU.RC;
        wVar.handleAction(23, null);
    }
}
