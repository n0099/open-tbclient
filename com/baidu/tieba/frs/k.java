package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class k implements View.OnTouchListener {
    final /* synthetic */ FrsActivity bzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsActivity frsActivity) {
        this.bzl = frsActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        cg cgVar;
        com.baidu.tieba.frs.h.an anVar;
        com.baidu.tieba.frs.h.an anVar2;
        cg cgVar2;
        cg cgVar3;
        cgVar = this.bzl.byC;
        if (cgVar != null) {
            cgVar2 = this.bzl.byC;
            if (cgVar2.Ya() != null) {
                cgVar3 = this.bzl.byC;
                cgVar3.Ya().onTouchEvent(motionEvent);
            }
        }
        anVar = this.bzl.byJ;
        if (anVar != null) {
            anVar2 = this.bzl.byJ;
            if (anVar2.b(motionEvent, view)) {
                return true;
            }
        }
        return false;
    }
}
