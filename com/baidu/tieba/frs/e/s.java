package com.baidu.tieba.frs.e;

import android.view.MotionEvent;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.b.d.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements h.a {
    final /* synthetic */ i cbx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(i iVar) {
        this.cbx = iVar;
    }

    @Override // com.baidu.tieba.b.d.h.a
    public void j(MotionEvent motionEvent) {
        NoPressedRelativeLayout noPressedRelativeLayout;
        if (motionEvent != null) {
            noPressedRelativeLayout = this.cbx.caH;
            noPressedRelativeLayout.setNeedInterceptTouchEvent(false);
            if (motionEvent.getAction() == 0) {
                this.cbx.cbf.setIsNeedIgnoreParentTouch(true);
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                this.cbx.cbf.setIsNeedIgnoreParentTouch(false);
            }
        }
    }
}
