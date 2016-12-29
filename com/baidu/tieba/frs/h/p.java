package com.baidu.tieba.frs.h;

import android.view.MotionEvent;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements NoPressedRelativeLayout.a {
    final /* synthetic */ i bPb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(i iVar) {
        this.bPb = iVar;
    }

    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
    public void f(MotionEvent motionEvent) {
        NoPressedRelativeLayout noPressedRelativeLayout;
        NoPressedRelativeLayout noPressedRelativeLayout2;
        NoPressedRelativeLayout noPressedRelativeLayout3;
        if (motionEvent != null && this.bPb.bOL != null && !this.bPb.bOL.NV()) {
            if (motionEvent.getAction() == 0) {
                noPressedRelativeLayout3 = this.bPb.bOn;
                noPressedRelativeLayout3.setNeedInterceptTouchEvent(false);
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (!this.bPb.bOL.ge(1)) {
                    noPressedRelativeLayout2 = this.bPb.bOn;
                    noPressedRelativeLayout2.setNeedInterceptTouchEvent(true);
                    this.bPb.bOL.NS();
                    return;
                }
                noPressedRelativeLayout = this.bPb.bOn;
                noPressedRelativeLayout.setNeedInterceptTouchEvent(false);
                this.bPb.bOO.setVisibility(8);
                this.bPb.bOP.setVisibility(8);
                this.bPb.bOQ.setVisibility(8);
                this.bPb.bOR.setVisibility(8);
                this.bPb.bOL.NT();
            }
        }
    }
}
