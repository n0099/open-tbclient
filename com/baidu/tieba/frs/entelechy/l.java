package com.baidu.tieba.frs.entelechy;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class l implements View.OnTouchListener {
    final /* synthetic */ d bnY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(d dVar) {
        this.bnY = dVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        PopupWindow popupWindow;
        FrsActivity frsActivity;
        if (motionEvent.getAction() == 4) {
            popupWindow = this.bnY.bvw;
            com.baidu.adp.lib.h.j.a(popupWindow);
            frsActivity = this.bnY.bjB;
            frsActivity.bgb = false;
        }
        return false;
    }
}
