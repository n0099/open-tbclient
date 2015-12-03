package com.baidu.tieba.frs.view;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnTouchListener {
    final /* synthetic */ q bkX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.bkX = qVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4) {
            com.baidu.adp.lib.h.j.a(this.bkX.bjW);
            this.bkX.baC.aZe = false;
        }
        return false;
    }
}
