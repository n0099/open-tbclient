package com.baidu.tieba.frs.i;

import android.view.MotionEvent;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.b.d.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements f.a {
    final /* synthetic */ h cfl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(h hVar) {
        this.cfl = hVar;
    }

    @Override // com.baidu.tieba.b.d.f.a
    public void f(MotionEvent motionEvent) {
        NoPressedRelativeLayout noPressedRelativeLayout;
        if (motionEvent != null) {
            noPressedRelativeLayout = this.cfl.ceJ;
            noPressedRelativeLayout.setNeedInterceptTouchEvent(false);
            if (motionEvent.getAction() == 0) {
                this.cfl.ceR.setIsNeedIgnoreParentTouch(true);
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                this.cfl.ceR.setIsNeedIgnoreParentTouch(false);
            }
        }
    }
}
