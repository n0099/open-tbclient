package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnTouchListener {
    final /* synthetic */ MsgleftView boI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(MsgleftView msgleftView) {
        this.boI = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.boI.boG;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.boI.bnW.onItemViewLongClick(view, 2, this.boI.anz, 0L);
            touchType2 = this.boI.boG;
            touchType2.set(false);
        }
        return false;
    }
}
