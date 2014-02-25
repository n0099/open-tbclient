package com.baidu.tieba.im.friend;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnTouchListener {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(u uVar) {
        this.a = uVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.a.k();
        return false;
    }
}
