package com.baidu.tieba.frs.j;

import android.view.ViewTreeObserver;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.frs.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ ai ckC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ai aiVar) {
        this.ckC = aiVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        com.baidu.tieba.frs.entelechy.b.d dVar;
        ObservedChangeLinearLayout observedChangeLinearLayout;
        int i;
        com.baidu.tieba.frs.entelechy.b.d dVar2;
        ObservedChangeLinearLayout observedChangeLinearLayout2;
        au auVar;
        au auVar2;
        dVar = this.ckC.ckr;
        if (dVar.aeK() != null) {
            observedChangeLinearLayout = this.ckC.cks;
            if (observedChangeLinearLayout != null) {
                i = this.ckC.mScreenHeight;
                if (i == 0) {
                    auVar = this.ckC.bVA;
                    if (auVar.adf() != null) {
                        ai aiVar = this.ckC;
                        auVar2 = this.ckC.bVA;
                        aiVar.mScreenHeight = auVar2.adf().getMeasuredHeight();
                    }
                }
                ai aiVar2 = this.ckC;
                dVar2 = this.ckC.ckr;
                int top = dVar2.aeK().getTop();
                observedChangeLinearLayout2 = this.ckC.cks;
                aiVar2.ckA = Math.abs(top - observedChangeLinearLayout2.getBottom()) <= 25;
            }
        }
    }
}
