package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements View.OnTouchListener {
    final /* synthetic */ MsgleftView aSx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(MsgleftView msgleftView) {
        this.aSx = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.aSx.aSv;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.aSx.mItemViewLongClickListener.onItemViewLongClick(view, 2, this.aSx.mPosition, 0L);
            touchType2 = this.aSx.aSv;
            touchType2.set(false);
        }
        return false;
    }
}
