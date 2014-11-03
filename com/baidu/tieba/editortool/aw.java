package com.baidu.tieba.editortool;

import android.view.View;
/* loaded from: classes.dex */
class aw implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.editortool.w arw;
    final /* synthetic */ TbEditorToolButtonContainer ase;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(TbEditorToolButtonContainer tbEditorToolButtonContainer, com.baidu.tbadk.editortool.w wVar) {
        this.ase = tbEditorToolButtonContainer;
        this.arw = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof EditorToolButton) {
            this.ase.a((EditorToolButton) view, this.arw);
        }
    }
}
