package com.baidu.tieba.frs.j;

import android.view.MotionEvent;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements NoPressedRelativeLayout.a {
    final /* synthetic */ f cjT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(f fVar) {
        this.cjT = fVar;
    }

    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
    public void g(MotionEvent motionEvent) {
        NoPressedRelativeLayout noPressedRelativeLayout;
        NoPressedRelativeLayout noPressedRelativeLayout2;
        NoPressedRelativeLayout noPressedRelativeLayout3;
        if (motionEvent != null && this.cjT.cjB != null && !this.cjT.cjB.OJ()) {
            if (motionEvent.getAction() == 0) {
                noPressedRelativeLayout3 = this.cjT.cjh;
                noPressedRelativeLayout3.setNeedInterceptTouchEvent(false);
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (!this.cjT.cjB.gf(1)) {
                    noPressedRelativeLayout2 = this.cjT.cjh;
                    noPressedRelativeLayout2.setNeedInterceptTouchEvent(true);
                    this.cjT.cjB.OG();
                    return;
                }
                noPressedRelativeLayout = this.cjT.cjh;
                noPressedRelativeLayout.setNeedInterceptTouchEvent(false);
                this.cjT.cjE.setVisibility(8);
                this.cjT.cjF.setVisibility(8);
                this.cjT.cjG.setVisibility(8);
                this.cjT.cjH.setVisibility(8);
                this.cjT.cjI.setVisibility(8);
                this.cjT.cjB.OH();
            }
        }
    }
}
