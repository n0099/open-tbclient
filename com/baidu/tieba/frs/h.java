package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class h implements View.OnTouchListener {
    final /* synthetic */ FrsActivity bDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsActivity frsActivity) {
        this.bDB = frsActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.d.c cVar;
        cVar = this.bDB.bCX;
        cVar.onTouchEvent(motionEvent);
        return false;
    }
}
