package com.baidu.tieba.frs.view;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnTouchListener {
    final /* synthetic */ FrsHeaderView bwy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsHeaderView frsHeaderView) {
        this.bwy = frsHeaderView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4) {
            com.baidu.adp.lib.h.j.a(this.bwy.bvI);
            this.bwy.blH.bkb = false;
        }
        return false;
    }
}
