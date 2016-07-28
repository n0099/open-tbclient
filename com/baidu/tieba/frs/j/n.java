package com.baidu.tieba.frs.j;

import android.view.MotionEvent;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.b.d.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements f.a {
    final /* synthetic */ h bUd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(h hVar) {
        this.bUd = hVar;
    }

    @Override // com.baidu.tieba.b.d.f.a
    public void d(MotionEvent motionEvent) {
        NoPressedRelativeLayout noPressedRelativeLayout;
        if (motionEvent != null) {
            noPressedRelativeLayout = this.bUd.bTB;
            noPressedRelativeLayout.setNeedInterceptTouchEvent(false);
            if (motionEvent.getAction() == 0) {
                this.bUd.bTJ.setIsNeedIgnoreParentTouch(true);
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                this.bUd.bTJ.setIsNeedIgnoreParentTouch(false);
            }
        }
    }
}
