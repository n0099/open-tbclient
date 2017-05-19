package com.baidu.tieba.frs.entelechy;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tieba.frs.r;
/* loaded from: classes.dex */
class i implements View.OnTouchListener {
    final /* synthetic */ c bRN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar) {
        this.bRN = cVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        PopupWindow popupWindow;
        r rVar;
        if (motionEvent.getAction() == 4) {
            popupWindow = this.bRN.ccu;
            com.baidu.adp.lib.g.j.a(popupWindow);
            rVar = this.bRN.bPw;
            rVar.bOa = false;
        }
        return false;
    }
}
