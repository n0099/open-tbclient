package com.baidu.tieba.frs.h;

import android.view.MotionEvent;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements NoPressedRelativeLayout.a {
    final /* synthetic */ e bup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(e eVar) {
        this.bup = eVar;
    }

    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
    public void d(MotionEvent motionEvent) {
        NoPressedRelativeLayout noPressedRelativeLayout;
        NoPressedRelativeLayout noPressedRelativeLayout2;
        NoPressedRelativeLayout noPressedRelativeLayout3;
        if (motionEvent != null && this.bup.btZ != null && !this.bup.btZ.JE()) {
            if (motionEvent.getAction() == 0) {
                noPressedRelativeLayout3 = this.bup.btR;
                noPressedRelativeLayout3.setNeedInterceptTouchEvent(false);
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (!this.bup.btZ.fs(1)) {
                    noPressedRelativeLayout2 = this.bup.btR;
                    noPressedRelativeLayout2.setNeedInterceptTouchEvent(true);
                    this.bup.btZ.JB();
                    return;
                }
                noPressedRelativeLayout = this.bup.btR;
                noPressedRelativeLayout.setNeedInterceptTouchEvent(false);
                this.bup.buc.setVisibility(8);
                this.bup.bud.setVisibility(8);
                this.bup.bue.setVisibility(8);
                this.bup.buf.setVisibility(8);
                this.bup.btZ.JC();
            }
        }
    }
}
