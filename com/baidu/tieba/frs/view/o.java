package com.baidu.tieba.frs.view;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class o implements View.OnTouchListener {
    final /* synthetic */ FrsHeaderView bow;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsHeaderView frsHeaderView) {
        this.bow = frsHeaderView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4) {
            com.baidu.adp.lib.h.j.a(this.bow.bnN);
            this.bow.beB.bda = false;
        }
        return false;
    }
}
