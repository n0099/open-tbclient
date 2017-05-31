package com.baidu.tieba.frs.f;

import android.view.MotionEvent;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements NoPressedRelativeLayout.a {
    final /* synthetic */ i chJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(i iVar) {
        this.chJ = iVar;
    }

    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
    public void j(MotionEvent motionEvent) {
        NoPressedRelativeLayout noPressedRelativeLayout;
        NoPressedRelativeLayout noPressedRelativeLayout2;
        NoPressedRelativeLayout noPressedRelativeLayout3;
        if (motionEvent != null && this.chJ.chq != null && !this.chJ.chq.SN()) {
            if (motionEvent.getAction() == 0) {
                noPressedRelativeLayout3 = this.chJ.cgT;
                noPressedRelativeLayout3.setNeedInterceptTouchEvent(false);
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (!this.chJ.chq.ha(1)) {
                    noPressedRelativeLayout2 = this.chJ.cgT;
                    noPressedRelativeLayout2.setNeedInterceptTouchEvent(true);
                    if (this.chJ.chD != null) {
                        this.chJ.chD.setVisibility(8);
                    }
                    this.chJ.chq.SK();
                    return;
                }
                noPressedRelativeLayout = this.chJ.cgT;
                noPressedRelativeLayout.setNeedInterceptTouchEvent(false);
                this.chJ.cht.setVisibility(8);
                this.chJ.chw.setVisibility(8);
                this.chJ.chu.setVisibility(8);
                this.chJ.chv.setVisibility(8);
                this.chJ.chq.SL();
            }
        }
    }
}
