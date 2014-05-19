package com.baidu.tbadk.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
/* loaded from: classes.dex */
class g extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ a a;

    private g(a aVar) {
        this.a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(a aVar, g gVar) {
        this(aVar);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (a.i(this.a) == 1 || a.i(this.a) == 2) {
            return false;
        }
        a.a(this.a, 2);
        if (a.j(this.a) > a.k(this.a)) {
            a.a(this.a, a.k(this.a));
            a.b(this.a, a.j(this.a));
            a.l(this.a);
            a.m(this.a);
            return true;
        }
        a.a(this.a, a.k(this.a) * 2.0f);
        a.a(this.a, true, (int) motionEvent.getX(), (int) motionEvent.getY());
        a.m(this.a);
        return true;
    }
}
