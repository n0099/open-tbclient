package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class j implements View.OnTouchListener {
    final /* synthetic */ FrsActivity bNJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.bNJ = frsActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        cg cgVar;
        com.baidu.tieba.frs.g.as asVar;
        com.baidu.tieba.frs.g.as asVar2;
        cg cgVar2;
        cg cgVar3;
        cgVar = this.bNJ.bMY;
        if (cgVar != null) {
            cgVar2 = this.bNJ.bMY;
            if (cgVar2.aaE() != null) {
                cgVar3 = this.bNJ.bMY;
                cgVar3.aaE().onTouchEvent(motionEvent);
            }
        }
        asVar = this.bNJ.bNd;
        if (asVar != null) {
            asVar2 = this.bNJ.bNd;
            if (asVar2.b(motionEvent, view)) {
                return true;
            }
        }
        return false;
    }
}
