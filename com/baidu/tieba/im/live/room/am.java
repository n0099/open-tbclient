package com.baidu.tieba.im.live.room;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class am implements View.OnTouchListener {
    final /* synthetic */ ag a;

    private am(ag agVar) {
        this.a = agVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ am(ag agVar, am amVar) {
        this(agVar);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view != null) {
            boolean z = ag.b(this.a) != 1;
            if (motionEvent.getAction() == 0) {
                if (System.currentTimeMillis() - ag.c(this.a) > 1000) {
                    ag.a(this.a, true);
                    ag.a(this.a, view);
                } else {
                    ag.a(this.a, false);
                }
            } else if (motionEvent.getAction() == 1) {
                if (z) {
                    ag.a(this.a, view, ag.d(this.a));
                } else {
                    ag.b(this.a, view, ag.d(this.a));
                }
            } else if (motionEvent.getAction() == 2) {
                ag.b(this.a, view, ag.d(this.a));
            } else if (motionEvent.getAction() == 3) {
                ag.b(this.a, view, ag.d(this.a));
            }
        }
        return false;
    }
}
