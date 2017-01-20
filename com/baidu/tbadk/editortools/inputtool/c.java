package com.baidu.tbadk.editortools.inputtool;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnTouchListener {
    final /* synthetic */ InputView auQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(InputView inputView) {
        this.auQ = inputView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.auQ.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            this.auQ.requestFocus();
        }
        return false;
    }
}
