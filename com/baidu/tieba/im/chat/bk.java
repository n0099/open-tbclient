package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements View.OnTouchListener {
    final /* synthetic */ MsgleftView cTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(MsgleftView msgleftView) {
        this.cTX = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.cTX.cTV;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.cTX.cTl.b(view, 2, this.cTX.aoC, 0L);
            touchType2 = this.cTX.cTV;
            touchType2.set(false);
        }
        return false;
    }
}
