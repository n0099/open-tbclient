package com.baidu.tieba.frs.entelechy;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class s implements View.OnTouchListener {
    final /* synthetic */ j bKz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(j jVar) {
        this.bKz = jVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        PopupWindow popupWindow;
        FrsActivity frsActivity;
        if (motionEvent.getAction() == 4) {
            popupWindow = this.bKz.bXi;
            com.baidu.adp.lib.g.j.a(popupWindow);
            frsActivity = this.bKz.bHh;
            frsActivity.bFs = false;
        }
        return false;
    }
}
