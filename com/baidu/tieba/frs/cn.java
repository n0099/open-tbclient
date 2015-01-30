package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
class cn implements View.OnTouchListener {
    final /* synthetic */ cf aGt;

    private cn(cf cfVar) {
        this.aGt = cfVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ cn(cf cfVar, cn cnVar) {
        this(cfVar);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                com.baidu.tbadk.core.data.x xVar = (com.baidu.tbadk.core.data.x) this.aGt.aD(((Integer) tag).intValue());
                View childAt = ((ViewGroup) view).getChildAt(0);
                if (childAt != null && xVar != null) {
                    boolean z = xVar.getPraise() == null || xVar.getPraise().getIsLike() == 0;
                    if (motionEvent.getAction() == 0) {
                        if (System.currentTimeMillis() - cf.c(this.aGt) > 1000) {
                            cf.a(this.aGt, true);
                            cf.a(this.aGt, childAt);
                        } else {
                            cf.a(this.aGt, false);
                        }
                    } else if (motionEvent.getAction() == 1) {
                        if (z) {
                            cf.a(this.aGt, childAt, cf.d(this.aGt));
                        } else {
                            cf.b(this.aGt, childAt, cf.d(this.aGt));
                        }
                    } else if (motionEvent.getAction() == 2) {
                        cf.b(this.aGt, childAt, cf.d(this.aGt));
                    } else if (motionEvent.getAction() == 3) {
                        cf.b(this.aGt, childAt, cf.d(this.aGt));
                    }
                }
            }
        }
        return false;
    }
}
