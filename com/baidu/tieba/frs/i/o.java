package com.baidu.tieba.frs.i;

import android.view.MotionEvent;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements NoPressedRelativeLayout.a {
    final /* synthetic */ h cfi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(h hVar) {
        this.cfi = hVar;
    }

    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
    public void f(MotionEvent motionEvent) {
        NoPressedRelativeLayout noPressedRelativeLayout;
        NoPressedRelativeLayout noPressedRelativeLayout2;
        FrsActivity frsActivity;
        NoPressedRelativeLayout noPressedRelativeLayout3;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        if (motionEvent != null && this.cfi.ceQ != null && !this.cfi.ceQ.NG()) {
            if (motionEvent.getAction() == 0) {
                frsActivity = this.cfi.bRi;
                if (frsActivity != null) {
                    frsActivity2 = this.cfi.bRi;
                    if (frsActivity2.aaJ() != null) {
                        frsActivity3 = this.cfi.bRi;
                        frsActivity3.aaJ().Zc();
                    }
                }
                noPressedRelativeLayout3 = this.cfi.ceI;
                noPressedRelativeLayout3.setNeedInterceptTouchEvent(false);
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (!this.cfi.ceQ.gf(1)) {
                    noPressedRelativeLayout2 = this.cfi.ceI;
                    noPressedRelativeLayout2.setNeedInterceptTouchEvent(true);
                    this.cfi.ceQ.ND();
                    return;
                }
                noPressedRelativeLayout = this.cfi.ceI;
                noPressedRelativeLayout.setNeedInterceptTouchEvent(false);
                this.cfi.ceT.setVisibility(8);
                this.cfi.ceU.setVisibility(8);
                this.cfi.ceV.setVisibility(8);
                this.cfi.ceW.setVisibility(8);
                this.cfi.ceX.setVisibility(8);
                this.cfi.ceQ.NE();
            }
        }
    }
}
