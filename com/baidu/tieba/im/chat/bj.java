package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements View.OnTouchListener {
    final /* synthetic */ MsgleftView cXT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(MsgleftView msgleftView) {
        this.cXT = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.cXT.cXR;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.cXT.cXh.b(view, 2, this.cXT.auq, 0L);
            touchType2 = this.cXT.cXR;
            touchType2.set(false);
        }
        return false;
    }
}
