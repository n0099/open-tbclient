package com.baidu.tieba.frs.g;

import android.view.ViewTreeObserver;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.frs.az;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ as ccm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar) {
        this.ccm = asVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        com.baidu.tieba.frs.entelechy.b.d dVar;
        ObservedChangeLinearLayout observedChangeLinearLayout;
        int i;
        com.baidu.tieba.frs.entelechy.b.d dVar2;
        ObservedChangeLinearLayout observedChangeLinearLayout2;
        az azVar;
        az azVar2;
        dVar = this.ccm.cca;
        if (dVar.abB() != null) {
            observedChangeLinearLayout = this.ccm.ccc;
            if (observedChangeLinearLayout != null) {
                i = this.ccm.mScreenHeight;
                if (i == 0) {
                    azVar = this.ccm.bQa;
                    if (azVar.aaf() != null) {
                        as asVar = this.ccm;
                        azVar2 = this.ccm.bQa;
                        asVar.mScreenHeight = azVar2.aaf().getMeasuredHeight();
                    }
                }
                as asVar2 = this.ccm;
                dVar2 = this.ccm.cca;
                int top = dVar2.abB().getTop();
                observedChangeLinearLayout2 = this.ccm.ccc;
                asVar2.ccj = Math.abs(top - observedChangeLinearLayout2.getBottom()) <= 25;
            }
        }
    }
}
