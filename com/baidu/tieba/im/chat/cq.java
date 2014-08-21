package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements View.OnTouchListener {
    final /* synthetic */ MsgleftView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(MsgleftView msgleftView) {
        this.a = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.a.x;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.a.c.b(view, 2, this.a.d, 0L);
            touchType2 = this.a.x;
            touchType2.set(false);
        }
        return false;
    }
}
