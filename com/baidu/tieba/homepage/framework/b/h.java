package com.baidu.tieba.homepage.framework.b;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnTouchListener {
    final /* synthetic */ e csG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.csG = eVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.d.c cVar;
        cVar = this.csG.csD;
        cVar.onTouchEvent(motionEvent);
        return false;
    }
}
