package com.baidu.tieba.im.friend;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnTouchListener {
    final /* synthetic */ s baL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.baL = sVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.baL.hideKeyboard();
        return false;
    }
}
