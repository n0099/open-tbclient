package com.baidu.tieba.frs.view;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
/* loaded from: classes.dex */
class t implements View.OnTouchListener {
    private final /* synthetic */ PopupWindow aOV;
    final /* synthetic */ o aOZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar, PopupWindow popupWindow) {
        this.aOZ = oVar;
        this.aOV = popupWindow;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4) {
            com.baidu.adp.lib.g.k.a(this.aOV);
            return false;
        }
        return false;
    }
}
