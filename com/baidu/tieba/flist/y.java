package com.baidu.tieba.flist;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnTouchListener {
    final /* synthetic */ w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar) {
        this.a = wVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.a.t.isShowing()) {
            this.a.t.dismiss();
            return false;
        }
        return false;
    }
}
