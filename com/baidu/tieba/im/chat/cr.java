package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cr implements View.OnTouchListener {
    final /* synthetic */ MsgleftView aPq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(MsgleftView msgleftView) {
        this.aPq = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.aPq.aPo;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.aPq.aOL.b(view, 2, this.aPq.Uy, 0L);
            touchType2 = this.aPq.aPo;
            touchType2.set(false);
        }
        return false;
    }
}
