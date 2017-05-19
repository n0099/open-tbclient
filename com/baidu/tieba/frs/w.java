package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnTouchListener {
    final /* synthetic */ r bPn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(r rVar) {
        this.bPn = rVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener;
        ca caVar;
        com.baidu.tieba.frs.e.u uVar;
        com.baidu.tieba.frs.e.u uVar2;
        ca caVar2;
        ca caVar3;
        View.OnTouchListener onTouchListener2;
        onTouchListener = this.bPn.bOS;
        if (onTouchListener != null) {
            onTouchListener2 = this.bPn.bOS;
            onTouchListener2.onTouch(view, motionEvent);
        }
        caVar = this.bPn.bOE;
        if (caVar != null) {
            caVar2 = this.bPn.bOE;
            if (caVar2.aae() != null) {
                caVar3 = this.bPn.bOE;
                caVar3.aae().onTouchEvent(motionEvent);
            }
        }
        this.bPn.bPe = true;
        uVar = this.bPn.bOx;
        if (uVar != null) {
            uVar2 = this.bPn.bOx;
            uVar2.onTouchEvent(motionEvent);
            return false;
        }
        return false;
    }
}
