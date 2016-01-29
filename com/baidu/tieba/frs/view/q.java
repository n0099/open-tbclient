package com.baidu.tieba.frs.view;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnTouchListener {
    final /* synthetic */ FrsHeaderView brq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsHeaderView frsHeaderView) {
        this.brq = frsHeaderView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4) {
            com.baidu.adp.lib.h.j.a(this.brq.bqF);
            this.brq.bgW.bfr = false;
        }
        return false;
    }
}
