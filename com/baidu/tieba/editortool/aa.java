package com.baidu.tieba.editortool;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aa implements View.OnTouchListener {
    final /* synthetic */ PbEditorToolView a;
    private final /* synthetic */ com.baidu.tbadk.editortool.x b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.x xVar) {
        this.a = pbEditorToolView;
        this.b = xVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.a.c.requestFocus();
            this.b.a(12, null);
        }
        return false;
    }
}
