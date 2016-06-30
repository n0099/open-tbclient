package com.baidu.tieba.homepage.framework.b;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnTouchListener {
    final /* synthetic */ e cqb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.cqb = eVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.d.c cVar;
        cVar = this.cqb.cpY;
        cVar.onTouchEvent(motionEvent);
        return false;
    }
}
