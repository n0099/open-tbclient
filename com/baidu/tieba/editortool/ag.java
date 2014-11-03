package com.baidu.tieba.editortool;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class ag implements View.OnTouchListener {
    final /* synthetic */ PbEditorToolView arE;
    private final /* synthetic */ com.baidu.tbadk.editortool.w arw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.w wVar) {
        this.arE = pbEditorToolView;
        this.arw = wVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.arE.mEditText.requestFocus();
            this.arw.handleAction(12, null);
        }
        return false;
    }
}
