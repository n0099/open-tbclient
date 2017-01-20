package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class j implements View.OnTouchListener {
    final /* synthetic */ FrsActivity bGL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.bGL = frsActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ce ceVar;
        com.baidu.tieba.frs.f.aq aqVar;
        com.baidu.tieba.frs.f.aq aqVar2;
        ce ceVar2;
        ce ceVar3;
        ceVar = this.bGL.bGb;
        if (ceVar != null) {
            ceVar2 = this.bGL.bGb;
            if (ceVar2.Zh() != null) {
                ceVar3 = this.bGL.bGb;
                ceVar3.Zh().onTouchEvent(motionEvent);
            }
        }
        aqVar = this.bGL.bGg;
        if (aqVar != null) {
            aqVar2 = this.bGL.bGg;
            if (aqVar2.b(motionEvent, view)) {
                return true;
            }
        }
        return false;
    }
}
