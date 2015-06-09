package com.baidu.tieba.frs.view;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
/* loaded from: classes.dex */
class t implements View.OnTouchListener {
    final /* synthetic */ o aRB;
    private final /* synthetic */ PopupWindow aRx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar, PopupWindow popupWindow) {
        this.aRB = oVar;
        this.aRx = popupWindow;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4) {
            com.baidu.adp.lib.g.k.a(this.aRx);
            this.aRB.aMl.aLa = false;
        }
        return false;
    }
}
