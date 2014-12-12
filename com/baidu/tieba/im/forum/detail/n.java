package com.baidu.tieba.im.forum.detail;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class n implements View.OnTouchListener {
    final /* synthetic */ k aZq;

    private n(k kVar) {
        this.aZq = kVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(k kVar, n nVar) {
        this(kVar);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                k.a(this.aZq).cN(false);
                break;
            case 1:
                k.a(this.aZq).cN(true);
                break;
            case 2:
                k.a(this.aZq).cN(false);
                break;
        }
        return false;
    }
}
