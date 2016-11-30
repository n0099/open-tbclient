package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements View.OnTouchListener {
    final /* synthetic */ MsgleftView dbc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(MsgleftView msgleftView) {
        this.dbc = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.dbc.dba;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.dbc.dan.b(view, 2, this.dbc.ape, 0L);
            touchType2 = this.dbc.dba;
            touchType2.set(false);
        }
        return false;
    }
}
