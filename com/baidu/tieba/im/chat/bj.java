package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements View.OnTouchListener {
    final /* synthetic */ MsgleftView cPX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(MsgleftView msgleftView) {
        this.cPX = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.cPX.cPV;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.cPX.cPl.b(view, 2, this.cPX.atn, 0L);
            touchType2 = this.cPX.cPV;
            touchType2.set(false);
        }
        return false;
    }
}
