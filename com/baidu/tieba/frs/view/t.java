package com.baidu.tieba.frs.view;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnTouchListener {
    final /* synthetic */ q bdN;
    private final /* synthetic */ PopupWindow bdv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar, PopupWindow popupWindow) {
        this.bdN = qVar;
        this.bdv = popupWindow;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4) {
            com.baidu.adp.lib.g.j.a(this.bdv);
            this.bdN.aVf.aTI = false;
        }
        return false;
    }
}
