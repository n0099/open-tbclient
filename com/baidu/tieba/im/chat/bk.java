package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements View.OnTouchListener {
    final /* synthetic */ MsgleftView cFD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(MsgleftView msgleftView) {
        this.cFD = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.cFD.cFB;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.cFD.cEQ.b(view, 2, this.cFD.akG, 0L);
            touchType2 = this.cFD.cFB;
            touchType2.set(false);
        }
        return false;
    }
}
