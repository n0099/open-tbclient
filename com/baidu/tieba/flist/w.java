package com.baidu.tieba.flist;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnTouchListener {
    final /* synthetic */ u awH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.awH = uVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.awH.awz.isShowing()) {
            com.baidu.adp.lib.g.j.a(this.awH.awz, this.awH.awB);
            return false;
        }
        return false;
    }
}
