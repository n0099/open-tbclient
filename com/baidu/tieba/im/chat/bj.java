package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements View.OnTouchListener {
    final /* synthetic */ MsgleftView bZO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(MsgleftView msgleftView) {
        this.bZO = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.bZO.bZM;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.bZO.bZb.b(view, 2, this.bZO.aom, 0L);
            touchType2 = this.bZO.bZM;
            touchType2.set(false);
        }
        return false;
    }
}
