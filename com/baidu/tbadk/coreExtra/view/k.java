package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ j NP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.NP = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        int i;
        View view2;
        view = this.NP.NK;
        if (view != null) {
            int childCount = ((LinearLayout) this.NP.getChildAt(0)).getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    i = 0;
                    break;
                }
                View childAt = ((LinearLayout) this.NP.getChildAt(0)).getChildAt(i2);
                view2 = this.NP.NK;
                if (childAt != view2) {
                    i2++;
                } else {
                    i = childAt.getRight();
                    break;
                }
            }
            this.NP.NK = null;
            int width = i - this.NP.getWidth();
            if (width > 0) {
                this.NP.scrollBy(width, 0);
            }
        }
    }
}
