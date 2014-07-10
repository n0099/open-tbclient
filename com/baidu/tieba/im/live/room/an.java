package com.baidu.tieba.im.live.room;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class an implements View.OnTouchListener {
    final /* synthetic */ ah a;

    private an(ah ahVar) {
        this.a = ahVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ an(ah ahVar, an anVar) {
        this(ahVar);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view != null) {
            boolean z = ah.b(this.a) != 1;
            if (motionEvent.getAction() == 0) {
                if (System.currentTimeMillis() - ah.c(this.a) > 1000) {
                    ah.a(this.a, true);
                    ah.a(this.a, view);
                } else {
                    ah.a(this.a, false);
                }
            } else if (motionEvent.getAction() == 1) {
                if (z) {
                    ah.a(this.a, view, ah.d(this.a));
                } else {
                    ah.b(this.a, view, ah.d(this.a));
                }
            } else if (motionEvent.getAction() == 2) {
                ah.b(this.a, view, ah.d(this.a));
            } else if (motionEvent.getAction() == 3) {
                ah.b(this.a, view, ah.d(this.a));
            }
        }
        return false;
    }
}
