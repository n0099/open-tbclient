package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
class bl implements View.OnTouchListener {
    final /* synthetic */ ba a;

    private bl(ba baVar) {
        this.a = baVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bl(ba baVar, bl blVar) {
        this(baVar);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.core.data.o oVar = (com.baidu.tbadk.core.data.o) this.a.getItem(((Integer) view.getTag()).intValue());
        View childAt = ((ViewGroup) view).getChildAt(0);
        if (childAt != null) {
            boolean z = oVar.j() == null || oVar.j().getIsLike() == 0;
            if (motionEvent.getAction() == 0) {
                if (System.currentTimeMillis() - ba.b(this.a) > 1000) {
                    ba.a(this.a, true);
                    ba.a(this.a, childAt);
                } else {
                    ba.a(this.a, false);
                }
            } else if (motionEvent.getAction() == 1) {
                if (z) {
                    ba.a(this.a, childAt, ba.c(this.a));
                } else {
                    ba.b(this.a, childAt, ba.c(this.a));
                }
            } else if (motionEvent.getAction() == 2) {
                ba.b(this.a, childAt, ba.c(this.a));
            } else if (motionEvent.getAction() == 3) {
                ba.b(this.a, childAt, ba.c(this.a));
            }
        }
        return false;
    }
}
