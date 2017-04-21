package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class j implements View.OnTouchListener {
    final /* synthetic */ FrsActivity bQa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.bQa = frsActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        cg cgVar;
        com.baidu.tieba.frs.g.as asVar;
        com.baidu.tieba.frs.g.as asVar2;
        cg cgVar2;
        cg cgVar3;
        cgVar = this.bQa.bPp;
        if (cgVar != null) {
            cgVar2 = this.bQa.bPp;
            if (cgVar2.abF() != null) {
                cgVar3 = this.bQa.bPp;
                cgVar3.abF().onTouchEvent(motionEvent);
            }
        }
        asVar = this.bQa.bPu;
        if (asVar != null) {
            asVar2 = this.bQa.bPu;
            if (asVar2.b(motionEvent, view)) {
                return true;
            }
        }
        return false;
    }
}
