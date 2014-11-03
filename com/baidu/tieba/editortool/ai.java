package com.baidu.tieba.editortool;

import android.view.View;
/* loaded from: classes.dex */
class ai implements View.OnClickListener {
    final /* synthetic */ PbEditorToolView arE;
    private final /* synthetic */ com.baidu.tbadk.editortool.w arw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.w wVar) {
        this.arE = pbEditorToolView;
        this.arw = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.arw.handleAction(10, null);
    }
}
