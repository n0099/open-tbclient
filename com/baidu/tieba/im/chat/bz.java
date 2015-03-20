package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements View.OnTouchListener {
    final /* synthetic */ MsgleftView aXQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(MsgleftView msgleftView) {
        this.aXQ = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.aXQ.aXO;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.aXQ.aXd.onItemViewLongClick(view, 2, this.aXQ.mPosition, 0L);
            touchType2 = this.aXQ.aXO;
            touchType2.set(false);
        }
        return false;
    }
}
