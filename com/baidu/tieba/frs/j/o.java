package com.baidu.tieba.frs.j;

import android.view.MotionEvent;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements NoPressedRelativeLayout.a {
    final /* synthetic */ h bUd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(h hVar) {
        this.bUd = hVar;
    }

    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
    public void d(MotionEvent motionEvent) {
        NoPressedRelativeLayout noPressedRelativeLayout;
        NoPressedRelativeLayout noPressedRelativeLayout2;
        FrsActivity frsActivity;
        NoPressedRelativeLayout noPressedRelativeLayout3;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        if (motionEvent != null && this.bUd.bTJ != null && !this.bUd.bTJ.KD()) {
            if (motionEvent.getAction() == 0) {
                frsActivity = this.bUd.bGh;
                if (frsActivity != null) {
                    frsActivity2 = this.bUd.bGh;
                    if (frsActivity2.VA() != null) {
                        frsActivity3 = this.bUd.bGh;
                        frsActivity3.VA().XB();
                    }
                }
                noPressedRelativeLayout3 = this.bUd.bTB;
                noPressedRelativeLayout3.setNeedInterceptTouchEvent(false);
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (!this.bUd.bTJ.fC(1)) {
                    noPressedRelativeLayout2 = this.bUd.bTB;
                    noPressedRelativeLayout2.setNeedInterceptTouchEvent(true);
                    this.bUd.bTJ.KA();
                    return;
                }
                noPressedRelativeLayout = this.bUd.bTB;
                noPressedRelativeLayout.setNeedInterceptTouchEvent(false);
                this.bUd.bTM.setVisibility(8);
                this.bUd.bTN.setVisibility(8);
                this.bUd.bTO.setVisibility(8);
                this.bUd.bTP.setVisibility(8);
                this.bUd.bTR.setVisibility(8);
                this.bUd.bTJ.KB();
            }
        }
    }
}
