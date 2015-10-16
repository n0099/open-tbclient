package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements View.OnTouchListener {
    final /* synthetic */ MsgleftView bsr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(MsgleftView msgleftView) {
        this.bsr = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.bsr.bsp;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.bsr.brE.onItemViewLongClick(view, 2, this.bsr.anL, 0L);
            touchType2 = this.bsr.bsp;
            touchType2.set(false);
        }
        return false;
    }
}
