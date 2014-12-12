package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements View.OnTouchListener {
    final /* synthetic */ MsgleftView aRo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(MsgleftView msgleftView) {
        this.aRo = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.aRo.aRm;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.aRo.mItemViewLongClickListener.onItemViewLongClick(view, 2, this.aRo.mPosition, 0L);
            touchType2 = this.aRo.aRm;
            touchType2.set(false);
        }
        return false;
    }
}
