package com.baidu.tieba.editortool;

import android.view.View;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ PbEditorToolButtonContainer a;
    private final /* synthetic */ com.baidu.tbadk.editortool.w b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbEditorToolButtonContainer pbEditorToolButtonContainer, com.baidu.tbadk.editortool.w wVar) {
        this.a = pbEditorToolButtonContainer;
        this.b = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof EditorToolButton) {
            this.a.a((EditorToolButton) view, this.b);
        }
    }
}
