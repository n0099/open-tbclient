package com.baidu.tieba.frs.view;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
/* loaded from: classes.dex */
class o implements View.OnTouchListener {
    final /* synthetic */ FrsHeaderView bdp;
    private final /* synthetic */ PopupWindow bdq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsHeaderView frsHeaderView, PopupWindow popupWindow) {
        this.bdp = frsHeaderView;
        this.bdq = popupWindow;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4) {
            com.baidu.adp.lib.g.j.a(this.bdq);
            this.bdp.aVM.aUB = false;
        }
        return false;
    }
}
