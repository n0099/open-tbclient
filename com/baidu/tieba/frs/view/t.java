package com.baidu.tieba.frs.view;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnTouchListener {
    private final /* synthetic */ PopupWindow bea;
    final /* synthetic */ q bes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar, PopupWindow popupWindow) {
        this.bes = qVar;
        this.bea = popupWindow;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4) {
            com.baidu.adp.lib.g.j.a(this.bea);
            this.bes.aVn.aTQ = false;
        }
        return false;
    }
}
