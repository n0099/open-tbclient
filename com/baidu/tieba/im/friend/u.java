package com.baidu.tieba.im.friend;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnTouchListener {
    final /* synthetic */ s a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.a = sVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.a.f();
        return false;
    }
}
