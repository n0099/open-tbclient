package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
final class bg implements View.OnTouchListener {
    final /* synthetic */ ay a;

    private bg(ay ayVar) {
        this.a = ayVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bg(ay ayVar, byte b) {
        this(ayVar);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.core.data.o oVar = (com.baidu.tbadk.core.data.o) this.a.getItem(((Integer) view.getTag()).intValue());
        View childAt = ((ViewGroup) view).getChildAt(0);
        if (childAt != null) {
            boolean z = oVar.k() == null || oVar.k().getIsLike() == 0;
            if (motionEvent.getAction() == 0) {
                if (System.currentTimeMillis() - ay.b(this.a) > 1000) {
                    ay.a(this.a, true);
                    ay.a(this.a, childAt);
                } else {
                    ay.a(this.a, false);
                }
            } else if (motionEvent.getAction() == 1) {
                if (z) {
                    ay.a(this.a, childAt, ay.c(this.a));
                } else {
                    ay.b(this.a, childAt, ay.c(this.a));
                }
            } else if (motionEvent.getAction() == 2) {
                ay.b(this.a, childAt, ay.c(this.a));
            } else if (motionEvent.getAction() == 3) {
                ay.b(this.a, childAt, ay.c(this.a));
            }
        }
        return false;
    }
}
