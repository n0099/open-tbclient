package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
class bn implements View.OnTouchListener {
    final /* synthetic */ az a;

    private bn(az azVar) {
        this.a = azVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bn(az azVar, bn bnVar) {
        this(azVar);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.core.data.m mVar = (com.baidu.tbadk.core.data.m) this.a.getItem(((Integer) view.getTag()).intValue());
        View childAt = ((ViewGroup) view).getChildAt(0);
        if (childAt != null) {
            boolean z = mVar.o() == null || mVar.o().getIsLike() == 0;
            if (motionEvent.getAction() == 0) {
                if (System.currentTimeMillis() - az.b(this.a) > 1000) {
                    az.a(this.a, true);
                    az.a(this.a, childAt);
                } else {
                    az.a(this.a, false);
                }
            } else if (motionEvent.getAction() == 1) {
                if (z) {
                    az.a(this.a, childAt, az.c(this.a));
                } else {
                    az.b(this.a, childAt, az.c(this.a));
                }
            } else if (motionEvent.getAction() == 2) {
                az.b(this.a, childAt, az.c(this.a));
            } else if (motionEvent.getAction() == 3) {
                az.b(this.a, childAt, az.c(this.a));
            }
        }
        return false;
    }
}
