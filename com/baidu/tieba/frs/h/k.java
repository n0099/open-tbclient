package com.baidu.tieba.frs.h;

import android.view.MotionEvent;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.a.d.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements f.a {
    final /* synthetic */ e bup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.bup = eVar;
    }

    @Override // com.baidu.tieba.a.d.f.a
    public void d(MotionEvent motionEvent) {
        NoPressedRelativeLayout noPressedRelativeLayout;
        if (motionEvent != null) {
            noPressedRelativeLayout = this.bup.btR;
            noPressedRelativeLayout.setNeedInterceptTouchEvent(false);
            if (motionEvent.getAction() == 0) {
                this.bup.btZ.setIsNeedIgnoreParentTouch(true);
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                this.bup.btZ.setIsNeedIgnoreParentTouch(false);
            }
        }
    }
}
