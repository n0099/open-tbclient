package com.baidu.tieba.frs.view;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
/* loaded from: classes.dex */
class n implements View.OnTouchListener {
    final /* synthetic */ FrsHeaderView aHJ;
    private final /* synthetic */ PopupWindow aHK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsHeaderView frsHeaderView, PopupWindow popupWindow) {
        this.aHJ = frsHeaderView;
        this.aHK = popupWindow;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4) {
            com.baidu.adp.lib.g.k.a(this.aHK);
            return false;
        }
        return false;
    }
}
