package com.baidu.tieba.editortool;

import android.view.View;
/* loaded from: classes.dex */
final class y implements View.OnClickListener {
    final /* synthetic */ PbEditorToolButtonContainer a;
    private final /* synthetic */ com.baidu.tbadk.editortool.x b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbEditorToolButtonContainer pbEditorToolButtonContainer, com.baidu.tbadk.editortool.x xVar) {
        this.a = pbEditorToolButtonContainer;
        this.b = xVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view instanceof EditorToolButton) {
            this.a.a((EditorToolButton) view, this.b);
        }
    }
}
