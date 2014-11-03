package com.baidu.tieba.frs.view;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
/* loaded from: classes.dex */
class m implements View.OnTouchListener {
    final /* synthetic */ FrsHeaderView aGd;
    private final /* synthetic */ PopupWindow aGe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsHeaderView frsHeaderView, PopupWindow popupWindow) {
        this.aGd = frsHeaderView;
        this.aGe = popupWindow;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4) {
            com.baidu.adp.lib.g.j.a(this.aGe);
            return false;
        }
        return false;
    }
}
