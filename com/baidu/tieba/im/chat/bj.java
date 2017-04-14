package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements View.OnTouchListener {
    final /* synthetic */ MsgleftView cOg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(MsgleftView msgleftView) {
        this.cOg = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.cOg.cOe;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.cOg.cNt.b(view, 2, this.cOg.atx, 0L);
            touchType2 = this.cOg.cOe;
            touchType2.set(false);
        }
        return false;
    }
}
