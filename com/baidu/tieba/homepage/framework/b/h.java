package com.baidu.tieba.homepage.framework.b;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnTouchListener {
    final /* synthetic */ e cEs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.cEs = eVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.d.c cVar;
        cVar = this.cEs.cEp;
        cVar.onTouchEvent(motionEvent);
        return false;
    }
}
