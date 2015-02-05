package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ j Uh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.Uh = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        int i;
        View view2;
        view = this.Uh.Uc;
        if (view != null) {
            int childCount = ((LinearLayout) this.Uh.getChildAt(0)).getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    i = 0;
                    break;
                }
                View childAt = ((LinearLayout) this.Uh.getChildAt(0)).getChildAt(i2);
                view2 = this.Uh.Uc;
                if (childAt != view2) {
                    i2++;
                } else {
                    i = childAt.getRight();
                    break;
                }
            }
            this.Uh.Uc = null;
            int width = i - this.Uh.getWidth();
            if (width > 0) {
                this.Uh.scrollBy(width, 0);
            }
        }
    }
}
