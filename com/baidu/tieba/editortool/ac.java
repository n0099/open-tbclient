package com.baidu.tieba.editortool;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class ac implements View.OnTouchListener {
    final /* synthetic */ PbEditorToolView a;
    private final /* synthetic */ com.baidu.tbadk.editortool.w b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.w wVar) {
        this.a = pbEditorToolView;
        this.b = wVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.a.c.requestFocus();
            this.b.a(12, null);
        }
        return false;
    }
}
