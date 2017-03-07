package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements View.OnTouchListener {
    final /* synthetic */ MsgleftView cPJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(MsgleftView msgleftView) {
        this.cPJ = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.cPJ.cPH;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.cPJ.cOW.b(view, 2, this.cPJ.ath, 0L);
            touchType2 = this.cPJ.cPH;
            touchType2.set(false);
        }
        return false;
    }
}
