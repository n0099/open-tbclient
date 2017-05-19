package com.baidu.tieba.frs.e;

import android.view.MotionEvent;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements NoPressedRelativeLayout.a {
    final /* synthetic */ i cbx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(i iVar) {
        this.cbx = iVar;
    }

    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
    public void j(MotionEvent motionEvent) {
        NoPressedRelativeLayout noPressedRelativeLayout;
        NoPressedRelativeLayout noPressedRelativeLayout2;
        NoPressedRelativeLayout noPressedRelativeLayout3;
        if (motionEvent != null && this.cbx.cbf != null && !this.cbx.cbf.SB()) {
            if (motionEvent.getAction() == 0) {
                noPressedRelativeLayout3 = this.cbx.caH;
                noPressedRelativeLayout3.setNeedInterceptTouchEvent(false);
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (!this.cbx.cbf.gJ(1)) {
                    noPressedRelativeLayout2 = this.cbx.caH;
                    noPressedRelativeLayout2.setNeedInterceptTouchEvent(true);
                    if (this.cbx.cbr != null) {
                        this.cbx.cbr.setVisibility(8);
                    }
                    this.cbx.cbf.Sy();
                    return;
                }
                noPressedRelativeLayout = this.cbx.caH;
                noPressedRelativeLayout.setNeedInterceptTouchEvent(false);
                this.cbx.cbi.setVisibility(8);
                this.cbx.cbj.setVisibility(8);
                this.cbx.cbk.setVisibility(8);
                this.cbx.cbf.Sz();
            }
        }
    }
}
