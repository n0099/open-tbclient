package com.baidu.tieba.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ac implements View.OnClickListener {
    final /* synthetic */ PbEditorToolView a;
    private final /* synthetic */ com.baidu.tbadk.editortool.x b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.x xVar) {
        this.a = pbEditorToolView;
        this.b = xVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.b.a(10, null);
    }
}
