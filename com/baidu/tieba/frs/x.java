package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnTouchListener {
    final /* synthetic */ r bVb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(r rVar) {
        this.bVb = rVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener;
        cb cbVar;
        com.baidu.tieba.frs.f.u uVar;
        com.baidu.tieba.frs.f.u uVar2;
        cb cbVar2;
        cb cbVar3;
        View.OnTouchListener onTouchListener2;
        onTouchListener = this.bVb.bUF;
        if (onTouchListener != null) {
            onTouchListener2 = this.bVb.bUF;
            onTouchListener2.onTouch(view, motionEvent);
        }
        cbVar = this.bVb.bUr;
        if (cbVar != null) {
            cbVar2 = this.bVb.bUr;
            if (cbVar2.abg() != null) {
                cbVar3 = this.bVb.bUr;
                cbVar3.abg().onTouchEvent(motionEvent);
            }
        }
        this.bVb.bUS = true;
        uVar = this.bVb.bUk;
        if (uVar != null) {
            uVar2 = this.bVb.bUk;
            uVar2.onTouchEvent(motionEvent);
            return false;
        }
        return false;
    }
}
