package com.baidu.tieba.frs.entelechy;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class l implements View.OnTouchListener {
    final /* synthetic */ d bIu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(d dVar) {
        this.bIu = dVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        PopupWindow popupWindow;
        FrsActivity frsActivity;
        if (motionEvent.getAction() == 4) {
            popupWindow = this.bIu.bTh;
            com.baidu.adp.lib.h.j.a(popupWindow);
            frsActivity = this.bIu.bET;
            frsActivity.bCq = false;
        }
        return false;
    }
}
