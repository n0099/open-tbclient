package com.baidu.tieba.frs.i;

import android.view.MotionEvent;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements NoPressedRelativeLayout.a {
    final /* synthetic */ h cfl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(h hVar) {
        this.cfl = hVar;
    }

    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
    public void f(MotionEvent motionEvent) {
        NoPressedRelativeLayout noPressedRelativeLayout;
        NoPressedRelativeLayout noPressedRelativeLayout2;
        FrsActivity frsActivity;
        NoPressedRelativeLayout noPressedRelativeLayout3;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        if (motionEvent != null && this.cfl.ceR != null && !this.cfl.ceR.Nf()) {
            if (motionEvent.getAction() == 0) {
                frsActivity = this.cfl.bRp;
                if (frsActivity != null) {
                    frsActivity2 = this.cfl.bRp;
                    if (frsActivity2.aav() != null) {
                        frsActivity3 = this.cfl.bRp;
                        frsActivity3.aav().YN();
                    }
                }
                noPressedRelativeLayout3 = this.cfl.ceJ;
                noPressedRelativeLayout3.setNeedInterceptTouchEvent(false);
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (!this.cfl.ceR.ga(1)) {
                    noPressedRelativeLayout2 = this.cfl.ceJ;
                    noPressedRelativeLayout2.setNeedInterceptTouchEvent(true);
                    this.cfl.ceR.Nc();
                    return;
                }
                noPressedRelativeLayout = this.cfl.ceJ;
                noPressedRelativeLayout.setNeedInterceptTouchEvent(false);
                this.cfl.ceU.setVisibility(8);
                this.cfl.ceV.setVisibility(8);
                this.cfl.ceW.setVisibility(8);
                this.cfl.ceX.setVisibility(8);
                this.cfl.ceZ.setVisibility(8);
                this.cfl.ceR.Nd();
            }
        }
    }
}
