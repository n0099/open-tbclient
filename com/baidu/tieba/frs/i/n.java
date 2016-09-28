package com.baidu.tieba.frs.i;

import android.view.MotionEvent;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.b.d.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements f.a {
    final /* synthetic */ h cfi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(h hVar) {
        this.cfi = hVar;
    }

    @Override // com.baidu.tieba.b.d.f.a
    public void f(MotionEvent motionEvent) {
        NoPressedRelativeLayout noPressedRelativeLayout;
        if (motionEvent != null) {
            noPressedRelativeLayout = this.cfi.ceI;
            noPressedRelativeLayout.setNeedInterceptTouchEvent(false);
            if (motionEvent.getAction() == 0) {
                this.cfi.ceQ.setIsNeedIgnoreParentTouch(true);
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                this.cfi.ceQ.setIsNeedIgnoreParentTouch(false);
            }
        }
    }
}
