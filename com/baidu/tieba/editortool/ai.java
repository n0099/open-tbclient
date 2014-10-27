package com.baidu.tieba.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.editortool.w arn;
    final /* synthetic */ PbEditorToolView arv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.w wVar) {
        this.arv = pbEditorToolView;
        this.arn = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.arn.handleAction(10, null);
    }
}
