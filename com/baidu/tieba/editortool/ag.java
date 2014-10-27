package com.baidu.tieba.editortool;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnTouchListener {
    private final /* synthetic */ com.baidu.tbadk.editortool.w arn;
    final /* synthetic */ PbEditorToolView arv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.w wVar) {
        this.arv = pbEditorToolView;
        this.arn = wVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.arv.mEditText.requestFocus();
            this.arn.handleAction(12, null);
        }
        return false;
    }
}
