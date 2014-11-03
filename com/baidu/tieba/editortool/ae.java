package com.baidu.tieba.editortool;

import android.view.View;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    final /* synthetic */ PbEditorToolButtonContainer arB;
    private final /* synthetic */ com.baidu.tbadk.editortool.w arw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PbEditorToolButtonContainer pbEditorToolButtonContainer, com.baidu.tbadk.editortool.w wVar) {
        this.arB = pbEditorToolButtonContainer;
        this.arw = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof EditorToolButton) {
            this.arB.a((EditorToolButton) view, this.arw);
        }
    }
}
