package com.baidu.tieba.frs.view;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
/* loaded from: classes.dex */
class y implements View.OnTouchListener {
    private final /* synthetic */ PopupWindow aFU;
    final /* synthetic */ r aGk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(r rVar, PopupWindow popupWindow) {
        this.aGk = rVar;
        this.aFU = popupWindow;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4) {
            com.baidu.adp.lib.g.j.a(this.aFU);
            return false;
        }
        return false;
    }
}
