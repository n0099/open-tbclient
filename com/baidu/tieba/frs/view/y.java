package com.baidu.tieba.frs.view;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnTouchListener {
    final /* synthetic */ u bwT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(u uVar) {
        this.bwT = uVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4) {
            com.baidu.adp.lib.h.j.a(this.bwT.bvI);
            this.bwT.blH.bkb = false;
        }
        return false;
    }
}
