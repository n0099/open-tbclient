package com.baidu.tieba.frs.view;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
/* loaded from: classes.dex */
class o implements View.OnTouchListener {
    final /* synthetic */ FrsHeaderView bcU;
    private final /* synthetic */ PopupWindow bcV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsHeaderView frsHeaderView, PopupWindow popupWindow) {
        this.bcU = frsHeaderView;
        this.bcV = popupWindow;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4) {
            com.baidu.adp.lib.g.j.a(this.bcV);
            this.bcU.aVx.aUn = false;
        }
        return false;
    }
}
