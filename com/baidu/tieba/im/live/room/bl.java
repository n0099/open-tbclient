package com.baidu.tieba.im.live.room;

import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class bl implements View.OnTouchListener {
    final /* synthetic */ bk a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bk bkVar) {
        this.a = bkVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                view.getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case 1:
            case 3:
                view.getParent().requestDisallowInterceptTouchEvent(false);
                break;
        }
        return false;
    }
}
