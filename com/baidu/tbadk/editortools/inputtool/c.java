package com.baidu.tbadk.editortools.inputtool;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnTouchListener {
    final /* synthetic */ InputView asK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(InputView inputView) {
        this.asK = inputView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.asK.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            this.asK.requestFocus();
        }
        return false;
    }
}
