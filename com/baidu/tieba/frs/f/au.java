package com.baidu.tieba.frs.f;

import android.view.ViewTreeObserver;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.frs.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ as cdL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar) {
        this.cdL = asVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        com.baidu.tieba.frs.entelechy.b.d dVar;
        ObservedChangeLinearLayout observedChangeLinearLayout;
        int i;
        com.baidu.tieba.frs.entelechy.b.d dVar2;
        ObservedChangeLinearLayout observedChangeLinearLayout2;
        ax axVar;
        ax axVar2;
        dVar = this.cdL.cdz;
        if (dVar.abe() != null) {
            observedChangeLinearLayout = this.cdL.cdB;
            if (observedChangeLinearLayout != null) {
                i = this.cdL.mScreenHeight;
                if (i == 0) {
                    axVar = this.cdL.bQl;
                    if (axVar.ZH() != null) {
                        as asVar = this.cdL;
                        axVar2 = this.cdL.bQl;
                        asVar.mScreenHeight = axVar2.ZH().getMeasuredHeight();
                    }
                }
                as asVar2 = this.cdL;
                dVar2 = this.cdL.cdz;
                int top = dVar2.abe().getTop();
                observedChangeLinearLayout2 = this.cdL.cdB;
                asVar2.cdI = Math.abs(top - observedChangeLinearLayout2.getBottom()) <= 25;
            }
        }
    }
}
