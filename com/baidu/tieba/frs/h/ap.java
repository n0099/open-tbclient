package com.baidu.tieba.frs.h;

import android.view.ViewTreeObserver;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.frs.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ an bPL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(an anVar) {
        this.bPL = anVar;
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
        dVar = this.bPL.bPA;
        if (dVar.Zf() != null) {
            observedChangeLinearLayout = this.bPL.bPB;
            if (observedChangeLinearLayout != null) {
                i = this.bPL.mScreenHeight;
                if (i == 0) {
                    axVar = this.bPL.bBI;
                    if (axVar.Xv() != null) {
                        an anVar = this.bPL;
                        axVar2 = this.bPL.bBI;
                        anVar.mScreenHeight = axVar2.Xv().getMeasuredHeight();
                    }
                }
                an anVar2 = this.bPL;
                dVar2 = this.bPL.bPA;
                int top = dVar2.Zf().getTop();
                observedChangeLinearLayout2 = this.bPL.bPB;
                anVar2.bPJ = Math.abs(top - observedChangeLinearLayout2.getBottom()) <= 25;
            }
        }
    }
}
