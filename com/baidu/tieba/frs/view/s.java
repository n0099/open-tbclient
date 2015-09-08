package com.baidu.tieba.frs.view;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnTouchListener {
    private final /* synthetic */ PopupWindow bdq;
    final /* synthetic */ p bdt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar, PopupWindow popupWindow) {
        this.bdt = pVar;
        this.bdq = popupWindow;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4) {
            com.baidu.adp.lib.g.j.a(this.bdq);
            this.bdt.aVM.aUB = false;
        }
        return false;
    }
}
