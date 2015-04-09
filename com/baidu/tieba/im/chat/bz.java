package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements View.OnTouchListener {
    final /* synthetic */ MsgleftView aYg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(MsgleftView msgleftView) {
        this.aYg = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.aYg.aYe;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.aYg.aXt.onItemViewLongClick(view, 2, this.aYg.mPosition, 0L);
            touchType2 = this.aYg.aYe;
            touchType2.set(false);
        }
        return false;
    }
}
