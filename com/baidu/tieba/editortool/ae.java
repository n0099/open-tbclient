package com.baidu.tieba.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ PbEditorToolView a;
    private final /* synthetic */ com.baidu.tbadk.editortool.w b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.w wVar) {
        this.a = pbEditorToolView;
        this.b = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.b.a(10, null);
    }
}
