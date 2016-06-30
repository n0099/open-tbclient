package com.baidu.tbadk.editortools.inputtool;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnTouchListener {
    final /* synthetic */ InputView arV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(InputView inputView) {
        this.arV = inputView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.arV.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            this.arV.requestFocus();
        }
        return false;
    }
}
