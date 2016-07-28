package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements View.OnTouchListener {
    final /* synthetic */ MsgleftView cIs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(MsgleftView msgleftView) {
        this.cIs = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.cIs.cIq;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.cIs.cHF.b(view, 2, this.cIs.alw, 0L);
            touchType2 = this.cIs.cIq;
            touchType2.set(false);
        }
        return false;
    }
}
