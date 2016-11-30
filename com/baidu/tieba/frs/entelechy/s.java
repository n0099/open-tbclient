package com.baidu.tieba.frs.entelechy;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class s implements View.OnTouchListener {
    final /* synthetic */ j bYo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(j jVar) {
        this.bYo = jVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        PopupWindow popupWindow;
        FrsActivity frsActivity;
        if (motionEvent.getAction() == 4) {
            popupWindow = this.bYo.clt;
            com.baidu.adp.lib.h.j.a(popupWindow);
            frsActivity = this.bYo.bTA;
            frsActivity.bRJ = false;
        }
        return false;
    }
}
