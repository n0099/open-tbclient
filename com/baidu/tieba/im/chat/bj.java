package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements View.OnTouchListener {
    final /* synthetic */ MsgleftView cKz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(MsgleftView msgleftView) {
        this.cKz = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.cKz.cKx;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.cKz.cJN.b(view, 2, this.cKz.atD, 0L);
            touchType2 = this.cKz.cKx;
            touchType2.set(false);
        }
        return false;
    }
}
