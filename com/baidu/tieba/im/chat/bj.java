package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements View.OnTouchListener {
    final /* synthetic */ MsgleftView bsV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(MsgleftView msgleftView) {
        this.bsV = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.bsV.bsT;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.bsV.bsi.onItemViewLongClick(view, 2, this.bsV.anQ, 0L);
            touchType2 = this.bsV.bsT;
            touchType2.set(false);
        }
        return false;
    }
}
