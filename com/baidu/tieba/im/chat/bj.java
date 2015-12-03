package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements View.OnTouchListener {
    final /* synthetic */ MsgleftView bIb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(MsgleftView msgleftView) {
        this.bIb = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.bIb.bHZ;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.bIb.bHo.onItemViewLongClick(view, 2, this.bIb.apI, 0L);
            touchType2 = this.bIb.bHZ;
            touchType2.set(false);
        }
        return false;
    }
}
