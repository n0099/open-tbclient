package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnTouchListener {
    final /* synthetic */ r cdl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(r rVar) {
        this.cdl = rVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener;
        cc ccVar;
        com.baidu.tieba.frs.f.m mVar;
        com.baidu.tieba.frs.f.m mVar2;
        cc ccVar2;
        cc ccVar3;
        View.OnTouchListener onTouchListener2;
        onTouchListener = this.cdl.ccN;
        if (onTouchListener != null) {
            onTouchListener2 = this.cdl.ccN;
            onTouchListener2.onTouch(view, motionEvent);
        }
        ccVar = this.cdl.ccz;
        if (ccVar != null) {
            ccVar2 = this.cdl.ccz;
            if (ccVar2.aeX() != null) {
                ccVar3 = this.cdl.ccz;
                ccVar3.aeX().onTouchEvent(motionEvent);
            }
        }
        this.cdl.cdb = true;
        mVar = this.cdl.cct;
        if (mVar != null) {
            mVar2 = this.cdl.cct;
            mVar2.onTouchEvent(motionEvent);
            return false;
        }
        return false;
    }
}
