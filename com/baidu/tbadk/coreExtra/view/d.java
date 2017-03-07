package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c asP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.asP = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        int i;
        View view2;
        view = this.asP.asK;
        if (view != null) {
            int childCount = ((LinearLayout) this.asP.getChildAt(0)).getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    i = 0;
                    break;
                }
                View childAt = ((LinearLayout) this.asP.getChildAt(0)).getChildAt(i2);
                view2 = this.asP.asK;
                if (childAt != view2) {
                    i2++;
                } else {
                    i = childAt.getRight();
                    break;
                }
            }
            this.asP.asK = null;
            int width = i - this.asP.getWidth();
            if (width > 0) {
                this.asP.scrollBy(width, 0);
            }
        }
    }
}
