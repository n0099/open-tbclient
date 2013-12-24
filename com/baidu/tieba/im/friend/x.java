package com.baidu.tieba.im.friend;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnTouchListener {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar) {
        this.a = tVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.a.k();
        return false;
    }
}
