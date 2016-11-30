package com.baidu.tieba.frs.j;

import android.view.MotionEvent;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.b.d.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements f.a {
    final /* synthetic */ f cjT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.cjT = fVar;
    }

    @Override // com.baidu.tieba.b.d.f.a
    public void g(MotionEvent motionEvent) {
        NoPressedRelativeLayout noPressedRelativeLayout;
        if (motionEvent != null) {
            noPressedRelativeLayout = this.cjT.cjh;
            noPressedRelativeLayout.setNeedInterceptTouchEvent(false);
            if (motionEvent.getAction() == 0) {
                this.cjT.cjB.setIsNeedIgnoreParentTouch(true);
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                this.cjT.cjB.setIsNeedIgnoreParentTouch(false);
            }
        }
    }
}
