package com.baidu.tieba.frs.view;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnTouchListener {
    final /* synthetic */ q bdC;
    private final /* synthetic */ PopupWindow bdk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar, PopupWindow popupWindow) {
        this.bdC = qVar;
        this.bdk = popupWindow;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4) {
            com.baidu.adp.lib.g.j.a(this.bdk);
            this.bdC.aUU.aTx = false;
        }
        return false;
    }
}
