package com.baidu.tieba.im.forum.detail;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class p implements View.OnTouchListener {
    final /* synthetic */ m baN;

    private p(m mVar) {
        this.baN = mVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(m mVar, p pVar) {
        this(mVar);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                m.a(this.baN).cS(false);
                break;
            case 1:
                m.a(this.baN).cS(true);
                break;
            case 2:
                m.a(this.baN).cS(false);
                break;
        }
        return false;
    }
}
