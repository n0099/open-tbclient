package com.baidu.tieba.frs.entelechy;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class m implements View.OnTouchListener {
    final /* synthetic */ e bJY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar) {
        this.bJY = eVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        PopupWindow popupWindow;
        FrsActivity frsActivity;
        if (motionEvent.getAction() == 4) {
            popupWindow = this.bJY.bVh;
            com.baidu.adp.lib.h.j.a(popupWindow);
            frsActivity = this.bJY.bGh;
            frsActivity.bDx = false;
        }
        return false;
    }
}
