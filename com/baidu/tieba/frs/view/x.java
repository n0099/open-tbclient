package com.baidu.tieba.frs.view;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
/* loaded from: classes.dex */
class x implements View.OnTouchListener {
    private final /* synthetic */ PopupWindow aIR;
    final /* synthetic */ o aIY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(o oVar, PopupWindow popupWindow) {
        this.aIY = oVar;
        this.aIR = popupWindow;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4) {
            com.baidu.adp.lib.g.k.a(this.aIR);
            return false;
        }
        return false;
    }
}
