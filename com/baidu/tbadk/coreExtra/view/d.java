package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c atl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.atl = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        int i;
        View view2;
        view = this.atl.atg;
        if (view != null) {
            int childCount = ((LinearLayout) this.atl.getChildAt(0)).getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    i = 0;
                    break;
                }
                View childAt = ((LinearLayout) this.atl.getChildAt(0)).getChildAt(i2);
                view2 = this.atl.atg;
                if (childAt != view2) {
                    i2++;
                } else {
                    i = childAt.getRight();
                    break;
                }
            }
            this.atl.atg = null;
            int width = i - this.atl.getWidth();
            if (width > 0) {
                this.atl.scrollBy(width, 0);
            }
        }
    }
}
