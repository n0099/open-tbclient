package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
class cn implements View.OnTouchListener {
    final /* synthetic */ cj aDA;

    private cn(cj cjVar) {
        this.aDA = cjVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ cn(cj cjVar, cn cnVar) {
        this(cjVar);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tbadk.core.data.q qVar = (com.baidu.tbadk.core.data.q) this.aDA.ai(((Integer) view.getTag()).intValue());
        View childAt = ((ViewGroup) view).getChildAt(0);
        if (childAt != null) {
            boolean z = qVar.getPraise() == null || qVar.getPraise().getIsLike() == 0;
            if (motionEvent.getAction() == 0) {
                if (System.currentTimeMillis() - cj.a(this.aDA) > 1000) {
                    cj.a(this.aDA, true);
                    cj.a(this.aDA, childAt);
                } else {
                    cj.a(this.aDA, false);
                }
            } else if (motionEvent.getAction() == 1) {
                if (z) {
                    cj.a(this.aDA, childAt, cj.b(this.aDA));
                } else {
                    cj.b(this.aDA, childAt, cj.b(this.aDA));
                }
            } else if (motionEvent.getAction() == 2) {
                cj.b(this.aDA, childAt, cj.b(this.aDA));
            } else if (motionEvent.getAction() == 3) {
                cj.b(this.aDA, childAt, cj.b(this.aDA));
            }
        }
        return false;
    }
}
