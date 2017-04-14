package com.baidu.tieba.frs.entelechy;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class r implements View.OnTouchListener {
    final /* synthetic */ j bRu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(j jVar) {
        this.bRu = jVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        PopupWindow popupWindow;
        FrsActivity frsActivity;
        if (motionEvent.getAction() == 4) {
            popupWindow = this.bRu.cdg;
            com.baidu.adp.lib.g.j.a(popupWindow);
            frsActivity = this.bRu.bOf;
            frsActivity.bMq = false;
        }
        return false;
    }
}
