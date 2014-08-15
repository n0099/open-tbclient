package com.baidu.tieba.im.live.room;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class ap implements View.OnTouchListener {
    final /* synthetic */ aj a;

    private ap(aj ajVar) {
        this.a = ajVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ap(aj ajVar, ap apVar) {
        this(ajVar);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view != null) {
            boolean z = aj.b(this.a) != 1;
            if (motionEvent.getAction() == 0) {
                if (System.currentTimeMillis() - aj.c(this.a) > 1000) {
                    aj.a(this.a, true);
                    aj.a(this.a, view);
                } else {
                    aj.a(this.a, false);
                }
            } else if (motionEvent.getAction() == 1) {
                if (z) {
                    aj.a(this.a, view, aj.d(this.a));
                } else {
                    aj.b(this.a, view, aj.d(this.a));
                }
            } else if (motionEvent.getAction() == 2) {
                aj.b(this.a, view, aj.d(this.a));
            } else if (motionEvent.getAction() == 3) {
                aj.b(this.a, view, aj.d(this.a));
            }
        }
        return false;
    }
}
