package com.baidu.tieba.editortool;

import android.view.View;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.editortool.w arn;
    final /* synthetic */ PbEditorToolButtonContainer ars;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PbEditorToolButtonContainer pbEditorToolButtonContainer, com.baidu.tbadk.editortool.w wVar) {
        this.ars = pbEditorToolButtonContainer;
        this.arn = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof EditorToolButton) {
            this.ars.a((EditorToolButton) view, this.arn);
        }
    }
}
