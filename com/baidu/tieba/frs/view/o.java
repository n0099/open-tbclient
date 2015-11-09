package com.baidu.tieba.frs.view;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
/* loaded from: classes.dex */
class o implements View.OnTouchListener {
    final /* synthetic */ FrsHeaderView bdZ;
    private final /* synthetic */ PopupWindow bea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsHeaderView frsHeaderView, PopupWindow popupWindow) {
        this.bdZ = frsHeaderView;
        this.bea = popupWindow;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4) {
            com.baidu.adp.lib.g.j.a(this.bea);
            this.bdZ.aVn.aTQ = false;
        }
        return false;
    }
}
