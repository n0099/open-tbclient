package com.baidu.tieba.homepage.framework.b;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnTouchListener {
    final /* synthetic */ e cwb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.cwb = eVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.e.c cVar;
        cVar = this.cwb.cvY;
        cVar.onTouchEvent(motionEvent);
        return false;
    }
}
