package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements View.OnTouchListener {
    final /* synthetic */ MsgleftView bsg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(MsgleftView msgleftView) {
        this.bsg = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.bsg.bse;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.bsg.brt.onItemViewLongClick(view, 2, this.bsg.anK, 0L);
            touchType2 = this.bsg.bse;
            touchType2.set(false);
        }
        return false;
    }
}
