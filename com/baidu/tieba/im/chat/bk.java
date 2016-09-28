package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements View.OnTouchListener {
    final /* synthetic */ MsgleftView cVr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(MsgleftView msgleftView) {
        this.cVr = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.cVr.cVp;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.cVr.cUF.b(view, 2, this.cVr.aok, 0L);
            touchType2 = this.cVr.cVp;
            touchType2.set(false);
        }
        return false;
    }
}
