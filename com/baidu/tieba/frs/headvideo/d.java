package com.baidu.tieba.frs.headvideo;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnTouchListener {
    final /* synthetic */ c bQb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bQb = cVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.bQb.XB();
        return false;
    }
}
