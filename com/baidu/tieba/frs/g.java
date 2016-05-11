package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnTouchListener {
    final /* synthetic */ FrsActivity bhl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsActivity frsActivity) {
        this.bhl = frsActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.c.c cVar;
        cVar = this.bhl.bgJ;
        cVar.onTouchEvent(motionEvent);
        return false;
    }
}
