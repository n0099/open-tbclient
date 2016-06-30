package com.baidu.tieba.frs.i;

import android.view.MotionEvent;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements NoPressedRelativeLayout.a {
    final /* synthetic */ h bSd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(h hVar) {
        this.bSd = hVar;
    }

    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
    public void d(MotionEvent motionEvent) {
        NoPressedRelativeLayout noPressedRelativeLayout;
        NoPressedRelativeLayout noPressedRelativeLayout2;
        NoPressedRelativeLayout noPressedRelativeLayout3;
        if (motionEvent != null && this.bSd.bRJ != null && !this.bSd.bRJ.KE()) {
            if (motionEvent.getAction() == 0) {
                noPressedRelativeLayout3 = this.bSd.bRB;
                noPressedRelativeLayout3.setNeedInterceptTouchEvent(false);
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (!this.bSd.bRJ.fD(1)) {
                    noPressedRelativeLayout2 = this.bSd.bRB;
                    noPressedRelativeLayout2.setNeedInterceptTouchEvent(true);
                    this.bSd.bRJ.KB();
                    return;
                }
                noPressedRelativeLayout = this.bSd.bRB;
                noPressedRelativeLayout.setNeedInterceptTouchEvent(false);
                this.bSd.bRM.setVisibility(8);
                this.bSd.bRN.setVisibility(8);
                this.bSd.bRO.setVisibility(8);
                this.bSd.bRP.setVisibility(8);
                this.bSd.bRR.setVisibility(8);
                this.bSd.bRJ.KC();
            }
        }
    }
}
