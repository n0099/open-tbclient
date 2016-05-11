package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements View.OnTouchListener {
    final /* synthetic */ MsgleftView cat;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(MsgleftView msgleftView) {
        this.cat = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.cat.car;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.cat.bZG.b(view, 2, this.cat.aka, 0L);
            touchType2 = this.cat.car;
            touchType2.set(false);
        }
        return false;
    }
}
