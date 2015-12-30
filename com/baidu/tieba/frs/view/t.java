package com.baidu.tieba.frs.view;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnTouchListener {
    final /* synthetic */ q boO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.boO = qVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4) {
            com.baidu.adp.lib.h.j.a(this.boO.bnN);
            this.boO.beB.bda = false;
        }
        return false;
    }
}
