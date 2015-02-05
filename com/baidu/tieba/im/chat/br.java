package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements View.OnTouchListener {
    final /* synthetic */ MsgleftView aSw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(MsgleftView msgleftView) {
        this.aSw = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.aSw.aSu;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.aSw.mItemViewLongClickListener.onItemViewLongClick(view, 2, this.aSw.mPosition, 0L);
            touchType2 = this.aSw.aSu;
            touchType2.set(false);
        }
        return false;
    }
}
