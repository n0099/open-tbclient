package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
class cn implements View.OnTouchListener {
    final /* synthetic */ cj aDK;

    private cn(cj cjVar) {
        this.aDK = cjVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ cn(cj cjVar, cn cnVar) {
        this(cjVar);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.core.data.q qVar = (com.baidu.tbadk.core.data.q) this.aDK.ai(((Integer) view.getTag()).intValue());
        View childAt = ((ViewGroup) view).getChildAt(0);
        if (childAt != null) {
            boolean z = qVar.getPraise() == null || qVar.getPraise().getIsLike() == 0;
            if (motionEvent.getAction() == 0) {
                if (System.currentTimeMillis() - cj.a(this.aDK) > 1000) {
                    cj.a(this.aDK, true);
                    cj.a(this.aDK, childAt);
                } else {
                    cj.a(this.aDK, false);
                }
            } else if (motionEvent.getAction() == 1) {
                if (z) {
                    cj.a(this.aDK, childAt, cj.b(this.aDK));
                } else {
                    cj.b(this.aDK, childAt, cj.b(this.aDK));
                }
            } else if (motionEvent.getAction() == 2) {
                cj.b(this.aDK, childAt, cj.b(this.aDK));
            } else if (motionEvent.getAction() == 3) {
                cj.b(this.aDK, childAt, cj.b(this.aDK));
            }
        }
        return false;
    }
}
