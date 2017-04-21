package com.baidu.tieba.frs.g;

import android.view.ViewTreeObserver;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.frs.az;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ as ceD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar) {
        this.ceD = asVar;
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
        dVar = this.ceD.cer;
        if (dVar.acC() != null) {
            observedChangeLinearLayout = this.ceD.cet;
            if (observedChangeLinearLayout != null) {
                i = this.ceD.mScreenHeight;
                if (i == 0) {
                    azVar = this.ceD.bSr;
                    if (azVar.abg() != null) {
                        as asVar = this.ceD;
                        azVar2 = this.ceD.bSr;
                        asVar.mScreenHeight = azVar2.abg().getMeasuredHeight();
                    }
                }
                as asVar2 = this.ceD;
                dVar2 = this.ceD.cer;
                int top = dVar2.acC().getTop();
                observedChangeLinearLayout2 = this.ceD.cet;
                asVar2.ceA = Math.abs(top - observedChangeLinearLayout2.getBottom()) <= 25;
            }
        }
    }
}
