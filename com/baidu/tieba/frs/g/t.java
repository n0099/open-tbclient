package com.baidu.tieba.frs.g;

import android.view.MotionEvent;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements NoPressedRelativeLayout.a {
    final /* synthetic */ i cbv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(i iVar) {
        this.cbv = iVar;
    }

    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
    public void j(MotionEvent motionEvent) {
        NoPressedRelativeLayout noPressedRelativeLayout;
        NoPressedRelativeLayout noPressedRelativeLayout2;
        NoPressedRelativeLayout noPressedRelativeLayout3;
        if (motionEvent != null && this.cbv.cbb != null && !this.cbv.cbb.Se()) {
            if (motionEvent.getAction() == 0) {
                noPressedRelativeLayout3 = this.cbv.caD;
                noPressedRelativeLayout3.setNeedInterceptTouchEvent(false);
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (!this.cbv.cbb.gG(1)) {
                    noPressedRelativeLayout2 = this.cbv.caD;
                    noPressedRelativeLayout2.setNeedInterceptTouchEvent(true);
                    if (this.cbv.cbp != null) {
                        this.cbv.cbp.setVisibility(8);
                    }
                    this.cbv.cbb.Sb();
                    return;
                }
                noPressedRelativeLayout = this.cbv.caD;
                noPressedRelativeLayout.setNeedInterceptTouchEvent(false);
                this.cbv.cbe.setVisibility(8);
                this.cbv.cbf.setVisibility(8);
                this.cbv.cbg.setVisibility(8);
                this.cbv.cbh.setVisibility(8);
                this.cbv.cbi.setVisibility(8);
                this.cbv.cbb.Sc();
            }
        }
    }
}
