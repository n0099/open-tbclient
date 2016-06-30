package com.baidu.tieba.frs.headvideo;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnTouchListener {
    final /* synthetic */ c bOp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bOp = cVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.frs.i.p pVar;
        com.baidu.tieba.frs.i.p pVar2;
        com.baidu.tieba.frs.i.p pVar3;
        this.bOp.Zb();
        pVar = this.bOp.bHa;
        if (pVar != null) {
            pVar2 = this.bOp.bHa;
            if (pVar2.aac() != null) {
                pVar3 = this.bOp.bHa;
                ForumHeadVideoView aay = pVar3.aac().aay();
                if (aay != null) {
                    aay.Zn();
                }
                a.YW();
                return false;
            }
            return false;
        }
        return false;
    }
}
