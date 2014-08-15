package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
class bo implements View.OnTouchListener {
    final /* synthetic */ bc a;

    private bo(bc bcVar) {
        this.a = bcVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bo(bc bcVar, bo boVar) {
        this(bcVar);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.core.data.n nVar = (com.baidu.tbadk.core.data.n) this.a.getItem(((Integer) view.getTag()).intValue());
        View childAt = ((ViewGroup) view).getChildAt(0);
        if (childAt != null) {
            boolean z = nVar.g() == null || nVar.g().getIsLike() == 0;
            if (motionEvent.getAction() == 0) {
                if (System.currentTimeMillis() - bc.a(this.a) > 1000) {
                    bc.a(this.a, true);
                    bc.a(this.a, childAt);
                } else {
                    bc.a(this.a, false);
                }
            } else if (motionEvent.getAction() == 1) {
                if (z) {
                    bc.a(this.a, childAt, bc.b(this.a));
                } else {
                    bc.b(this.a, childAt, bc.b(this.a));
                }
            } else if (motionEvent.getAction() == 2) {
                bc.b(this.a, childAt, bc.b(this.a));
            } else if (motionEvent.getAction() == 3) {
                bc.b(this.a, childAt, bc.b(this.a));
            }
        }
        return false;
    }
}
