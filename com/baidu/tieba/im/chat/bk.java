package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements View.OnTouchListener {
    final /* synthetic */ MsgleftView cGm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(MsgleftView msgleftView) {
        this.cGm = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.cGm.cGk;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.cGm.cFz.b(view, 2, this.cGm.aoG, 0L);
            touchType2 = this.cGm.cGk;
            touchType2.set(false);
        }
        return false;
    }
}
