package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
class cm implements View.OnTouchListener {
    final /* synthetic */ cg aFl;

    private cm(cg cgVar) {
        this.aFl = cgVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ cm(cg cgVar, cm cmVar) {
        this(cgVar);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.core.data.w wVar = (com.baidu.tbadk.core.data.w) this.aFl.ay(((Integer) view.getTag()).intValue());
        View childAt = ((ViewGroup) view).getChildAt(0);
        if (childAt != null) {
            boolean z = wVar.getPraise() == null || wVar.getPraise().getIsLike() == 0;
            if (motionEvent.getAction() == 0) {
                if (System.currentTimeMillis() - cg.a(this.aFl) > 1000) {
                    cg.a(this.aFl, true);
                    cg.a(this.aFl, childAt);
                } else {
                    cg.a(this.aFl, false);
                }
            } else if (motionEvent.getAction() == 1) {
                if (z) {
                    cg.a(this.aFl, childAt, cg.b(this.aFl));
                } else {
                    cg.b(this.aFl, childAt, cg.b(this.aFl));
                }
            } else if (motionEvent.getAction() == 2) {
                cg.b(this.aFl, childAt, cg.b(this.aFl));
            } else if (motionEvent.getAction() == 3) {
                cg.b(this.aFl, childAt, cg.b(this.aFl));
            }
        }
        return false;
    }
}
