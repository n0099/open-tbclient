package com.baidu.tieba.frs.view;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class r implements View.OnTouchListener {
    final /* synthetic */ FrsHeaderView bwi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsHeaderView frsHeaderView) {
        this.bwi = frsHeaderView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4) {
            com.baidu.adp.lib.h.j.a(this.bwi.bvw);
            this.bwi.bjB.bgb = false;
        }
        return false;
    }
}
