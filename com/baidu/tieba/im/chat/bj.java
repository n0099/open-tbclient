package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements View.OnTouchListener {
    final /* synthetic */ MsgleftView bPw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(MsgleftView msgleftView) {
        this.bPw = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.bPw.bPu;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.bPw.bOJ.b(view, 2, this.bPw.anV, 0L);
            touchType2 = this.bPw.bPu;
            touchType2.set(false);
        }
        return false;
    }
}
