package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cr implements View.OnTouchListener {
    final /* synthetic */ MsgleftView aPE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(MsgleftView msgleftView) {
        this.aPE = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.aPE.aPC;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.aPE.aOZ.b(view, 2, this.aPE.UC, 0L);
            touchType2 = this.aPE.aPC;
            touchType2.set(false);
        }
        return false;
    }
}
