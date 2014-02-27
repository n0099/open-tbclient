package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ca implements View.OnTouchListener {
    final /* synthetic */ MsgleftView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(MsgleftView msgleftView) {
        this.a = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.a.v;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.a.d.a(2, this.a.f);
            touchType2 = this.a.v;
            touchType2.set(false);
        }
        return false;
    }
}
