package com.baidu.tieba.homepage.framework.b;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnTouchListener {
    final /* synthetic */ e cxB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.cxB = eVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.e.c cVar;
        cVar = this.cxB.cxy;
        cVar.onTouchEvent(motionEvent);
        return false;
    }
}
