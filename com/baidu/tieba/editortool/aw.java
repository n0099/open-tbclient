package com.baidu.tieba.editortool;

import android.view.View;
/* loaded from: classes.dex */
class aw implements View.OnClickListener {
    final /* synthetic */ TbEditorToolButtonContainer arV;
    private final /* synthetic */ com.baidu.tbadk.editortool.w arn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(TbEditorToolButtonContainer tbEditorToolButtonContainer, com.baidu.tbadk.editortool.w wVar) {
        this.arV = tbEditorToolButtonContainer;
        this.arn = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof EditorToolButton) {
            this.arV.a((EditorToolButton) view, this.arn);
        }
    }
}
