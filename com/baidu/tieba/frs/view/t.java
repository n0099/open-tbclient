package com.baidu.tieba.frs.view;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
/* loaded from: classes.dex */
class t implements View.OnTouchListener {
    final /* synthetic */ o aRA;
    private final /* synthetic */ PopupWindow aRw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar, PopupWindow popupWindow) {
        this.aRA = oVar;
        this.aRw = popupWindow;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4) {
            com.baidu.adp.lib.g.k.a(this.aRw);
            this.aRA.aMk.aKZ = false;
        }
        return false;
    }
}
