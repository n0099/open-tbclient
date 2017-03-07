package com.baidu.tieba.frs.f;

import android.view.MotionEvent;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements NoPressedRelativeLayout.a {
    final /* synthetic */ i ccU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(i iVar) {
        this.ccU = iVar;
    }

    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
    public void f(MotionEvent motionEvent) {
        NoPressedRelativeLayout noPressedRelativeLayout;
        NoPressedRelativeLayout noPressedRelativeLayout2;
        NoPressedRelativeLayout noPressedRelativeLayout3;
        if (motionEvent != null && this.ccU.ccA != null && !this.ccU.ccA.RG()) {
            if (motionEvent.getAction() == 0) {
                noPressedRelativeLayout3 = this.ccU.ccc;
                noPressedRelativeLayout3.setNeedInterceptTouchEvent(false);
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (!this.ccU.ccA.gD(1)) {
                    noPressedRelativeLayout2 = this.ccU.ccc;
                    noPressedRelativeLayout2.setNeedInterceptTouchEvent(true);
                    if (this.ccU.ccO != null) {
                        this.ccU.ccO.setVisibility(8);
                    }
                    this.ccU.ccA.RD();
                    return;
                }
                noPressedRelativeLayout = this.ccU.ccc;
                noPressedRelativeLayout.setNeedInterceptTouchEvent(false);
                this.ccU.ccD.setVisibility(8);
                this.ccU.ccE.setVisibility(8);
                this.ccU.ccF.setVisibility(8);
                this.ccU.ccG.setVisibility(8);
                this.ccU.ccH.setVisibility(8);
                this.ccU.ccA.RE();
            }
        }
    }
}
