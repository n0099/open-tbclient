package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements View.OnTouchListener {
    final /* synthetic */ MsgleftView bLI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(MsgleftView msgleftView) {
        this.bLI = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.bLI.bLG;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.bLI.bKV.onItemViewLongClick(view, 2, this.bLI.anc, 0L);
            touchType2 = this.bLI.bLG;
            touchType2.set(false);
        }
        return false;
    }
}
