package com.baidu.tieba.frs.view;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
/* loaded from: classes.dex */
class y implements View.OnTouchListener {
    private final /* synthetic */ PopupWindow aGe;
    final /* synthetic */ r aGu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(r rVar, PopupWindow popupWindow) {
        this.aGu = rVar;
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
