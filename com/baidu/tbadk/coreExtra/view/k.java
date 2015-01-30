package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ j Uk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.Uk = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        int i;
        View view2;
        view = this.Uk.Uf;
        if (view != null) {
            int childCount = ((LinearLayout) this.Uk.getChildAt(0)).getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    i = 0;
                    break;
                }
                View childAt = ((LinearLayout) this.Uk.getChildAt(0)).getChildAt(i2);
                view2 = this.Uk.Uf;
                if (childAt != view2) {
                    i2++;
                } else {
                    i = childAt.getRight();
                    break;
                }
            }
            this.Uk.Uf = null;
            int width = i - this.Uk.getWidth();
            if (width > 0) {
                this.Uk.scrollBy(width, 0);
            }
        }
    }
}
