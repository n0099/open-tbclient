package com.baidu.tbadk.editortools.inputtool;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnTouchListener {
    final /* synthetic */ InputView avu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(InputView inputView) {
        this.avu = inputView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.avu.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            this.avu.requestFocus();
        }
        return false;
    }
}
