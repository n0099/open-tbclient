package com.baidu.tieba.im.friend;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnTouchListener {
    final /* synthetic */ s bcg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.bcg = sVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.bcg.OT();
        return false;
    }
}
