package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnTouchListener {
    final /* synthetic */ FrsActivity bTa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsActivity frsActivity) {
        this.bTa = frsActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ch chVar;
        com.baidu.tieba.frs.j.ai aiVar;
        com.baidu.tieba.frs.j.ai aiVar2;
        ch chVar2;
        ch chVar3;
        chVar = this.bTa.bSs;
        if (chVar != null) {
            chVar2 = this.bTa.bSs;
            if (chVar2.adH() != null) {
                chVar3 = this.bTa.bSs;
                chVar3.adH().onTouchEvent(motionEvent);
            }
        }
        aiVar = this.bTa.bSA;
        if (aiVar != null) {
            aiVar2 = this.bTa.bSA;
            if (aiVar2.b(motionEvent, view)) {
                return true;
            }
        }
        return false;
    }
}
