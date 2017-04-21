package com.baidu.tieba.frs.g;

import android.view.MotionEvent;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements NoPressedRelativeLayout.a {
    final /* synthetic */ i cdM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(i iVar) {
        this.cdM = iVar;
    }

    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
    public void j(MotionEvent motionEvent) {
        NoPressedRelativeLayout noPressedRelativeLayout;
        NoPressedRelativeLayout noPressedRelativeLayout2;
        NoPressedRelativeLayout noPressedRelativeLayout3;
        if (motionEvent != null && this.cdM.cds != null && !this.cdM.cds.Tg()) {
            if (motionEvent.getAction() == 0) {
                noPressedRelativeLayout3 = this.cdM.ccU;
                noPressedRelativeLayout3.setNeedInterceptTouchEvent(false);
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (!this.cdM.cds.gM(1)) {
                    noPressedRelativeLayout2 = this.cdM.ccU;
                    noPressedRelativeLayout2.setNeedInterceptTouchEvent(true);
                    if (this.cdM.cdG != null) {
                        this.cdM.cdG.setVisibility(8);
                    }
                    this.cdM.cds.Td();
                    return;
                }
                noPressedRelativeLayout = this.cdM.ccU;
                noPressedRelativeLayout.setNeedInterceptTouchEvent(false);
                this.cdM.cdv.setVisibility(8);
                this.cdM.cdw.setVisibility(8);
                this.cdM.cdx.setVisibility(8);
                this.cdM.cdy.setVisibility(8);
                this.cdM.cdz.setVisibility(8);
                this.cdM.cds.Te();
            }
        }
    }
}
