package com.baidu.tieba.frs.f;

import android.view.ViewTreeObserver;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.frs.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ aq bWq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(aq aqVar) {
        this.bWq = aqVar;
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
        dVar = this.bWq.bWe;
        if (dVar.aah() != null) {
            observedChangeLinearLayout = this.bWq.bWg;
            if (observedChangeLinearLayout != null) {
                i = this.bWq.mScreenHeight;
                if (i == 0) {
                    axVar = this.bWq.bJc;
                    if (axVar.YI() != null) {
                        aq aqVar = this.bWq;
                        axVar2 = this.bWq.bJc;
                        aqVar.mScreenHeight = axVar2.YI().getMeasuredHeight();
                    }
                }
                aq aqVar2 = this.bWq;
                dVar2 = this.bWq.bWe;
                int top = dVar2.aah().getTop();
                observedChangeLinearLayout2 = this.bWq.bWg;
                aqVar2.bWn = Math.abs(top - observedChangeLinearLayout2.getBottom()) <= 25;
            }
        }
    }
}
