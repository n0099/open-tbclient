package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements View.OnTouchListener {
    final /* synthetic */ MsgleftView cNu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(MsgleftView msgleftView) {
        this.cNu = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.cNu.cNs;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.cNu.cMH.b(view, 2, this.cNu.anM, 0L);
            touchType2 = this.cNu.cNs;
            touchType2.set(false);
        }
        return false;
    }
}
