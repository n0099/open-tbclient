package com.baidu.tieba.flist;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnTouchListener {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.a = uVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.a.u.isShowing()) {
            com.baidu.adp.lib.e.e.a(this.a.u, this.a.w);
            return false;
        }
        return false;
    }
}
