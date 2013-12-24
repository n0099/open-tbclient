package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements View.OnTouchListener {
    final /* synthetic */ bu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bu buVar) {
        this.a = buVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.a.K();
        this.a.L();
        this.a.M();
        return false;
    }
}
