package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c asV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.asV = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        int i;
        View view2;
        view = this.asV.asQ;
        if (view != null) {
            int childCount = ((LinearLayout) this.asV.getChildAt(0)).getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    i = 0;
                    break;
                }
                View childAt = ((LinearLayout) this.asV.getChildAt(0)).getChildAt(i2);
                view2 = this.asV.asQ;
                if (childAt != view2) {
                    i2++;
                } else {
                    i = childAt.getRight();
                    break;
                }
            }
            this.asV.asQ = null;
            int width = i - this.asV.getWidth();
            if (width > 0) {
                this.asV.scrollBy(width, 0);
            }
        }
    }
}
