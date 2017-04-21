package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements View.OnTouchListener {
    final /* synthetic */ MsgleftView cQx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(MsgleftView msgleftView) {
        this.cQx = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.cQx.cQv;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.cQx.cPK.b(view, 2, this.cQx.atz, 0L);
            touchType2 = this.cQx.cQv;
            touchType2.set(false);
        }
        return false;
    }
}
