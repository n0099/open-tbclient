package com.baidu.tieba.frs.view;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnTouchListener {
    final /* synthetic */ t brL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar) {
        this.brL = tVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4) {
            com.baidu.adp.lib.h.j.a(this.brL.bqF);
            this.brL.bgW.bfr = false;
        }
        return false;
    }
}
