package com.baidu.tieba.frs.entelechy;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class r implements View.OnTouchListener {
    final /* synthetic */ j bTL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(j jVar) {
        this.bTL = jVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        PopupWindow popupWindow;
        FrsActivity frsActivity;
        if (motionEvent.getAction() == 4) {
            popupWindow = this.bTL.cfx;
            com.baidu.adp.lib.g.j.a(popupWindow);
            frsActivity = this.bTL.bQw;
            frsActivity.bOH = false;
        }
        return false;
    }
}
