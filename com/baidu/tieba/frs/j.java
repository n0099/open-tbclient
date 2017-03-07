package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class j implements View.OnTouchListener {
    final /* synthetic */ FrsActivity bNU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.bNU = frsActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ce ceVar;
        com.baidu.tieba.frs.f.as asVar;
        com.baidu.tieba.frs.f.as asVar2;
        ce ceVar2;
        ce ceVar3;
        ceVar = this.bNU.bNj;
        if (ceVar != null) {
            ceVar2 = this.bNU.bNj;
            if (ceVar2.aag() != null) {
                ceVar3 = this.bNU.bNj;
                ceVar3.aag().onTouchEvent(motionEvent);
            }
        }
        asVar = this.bNU.bNo;
        if (asVar != null) {
            asVar2 = this.bNU.bNo;
            if (asVar2.b(motionEvent, view)) {
                return true;
            }
        }
        return false;
    }
}
