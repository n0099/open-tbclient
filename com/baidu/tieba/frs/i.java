package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class i implements View.OnTouchListener {
    final /* synthetic */ FrsActivity bQp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsActivity frsActivity) {
        this.bQp = frsActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.e.c cVar;
        cVar = this.bQp.bPI;
        cVar.onTouchEvent(motionEvent);
        return false;
    }
}
