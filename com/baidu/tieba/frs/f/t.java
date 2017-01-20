package com.baidu.tieba.frs.f;

import android.view.MotionEvent;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements NoPressedRelativeLayout.a {
    final /* synthetic */ i bVC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(i iVar) {
        this.bVC = iVar;
    }

    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
    public void f(MotionEvent motionEvent) {
        NoPressedRelativeLayout noPressedRelativeLayout;
        NoPressedRelativeLayout noPressedRelativeLayout2;
        NoPressedRelativeLayout noPressedRelativeLayout3;
        if (motionEvent != null && this.bVC.bVi != null && !this.bVC.bVi.QO()) {
            if (motionEvent.getAction() == 0) {
                noPressedRelativeLayout3 = this.bVC.bUK;
                noPressedRelativeLayout3.setNeedInterceptTouchEvent(false);
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (!this.bVC.bVi.gG(1)) {
                    noPressedRelativeLayout2 = this.bVC.bUK;
                    noPressedRelativeLayout2.setNeedInterceptTouchEvent(true);
                    if (this.bVC.bVw != null) {
                        this.bVC.bVw.setVisibility(8);
                    }
                    this.bVC.bVi.QL();
                    return;
                }
                noPressedRelativeLayout = this.bVC.bUK;
                noPressedRelativeLayout.setNeedInterceptTouchEvent(false);
                this.bVC.bVl.setVisibility(8);
                this.bVC.bVm.setVisibility(8);
                this.bVC.bVn.setVisibility(8);
                this.bVC.bVo.setVisibility(8);
                this.bVC.bVp.setVisibility(8);
                this.bVC.bVi.QM();
            }
        }
    }
}
