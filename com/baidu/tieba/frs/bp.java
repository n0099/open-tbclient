package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
class bp implements View.OnTouchListener {
    final /* synthetic */ bd a;

    private bp(bd bdVar) {
        this.a = bdVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bp(bd bdVar, bp bpVar) {
        this(bdVar);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.core.data.n nVar = (com.baidu.tbadk.core.data.n) this.a.getItem(((Integer) view.getTag()).intValue());
        View childAt = ((ViewGroup) view).getChildAt(0);
        if (childAt != null) {
            boolean z = nVar.g() == null || nVar.g().getIsLike() == 0;
            if (motionEvent.getAction() == 0) {
                if (System.currentTimeMillis() - bd.a(this.a) > 1000) {
                    bd.a(this.a, true);
                    bd.a(this.a, childAt);
                } else {
                    bd.a(this.a, false);
                }
            } else if (motionEvent.getAction() == 1) {
                if (z) {
                    bd.a(this.a, childAt, bd.b(this.a));
                } else {
                    bd.b(this.a, childAt, bd.b(this.a));
                }
            } else if (motionEvent.getAction() == 2) {
                bd.b(this.a, childAt, bd.b(this.a));
            } else if (motionEvent.getAction() == 3) {
                bd.b(this.a, childAt, bd.b(this.a));
            }
        }
        return false;
    }
}
