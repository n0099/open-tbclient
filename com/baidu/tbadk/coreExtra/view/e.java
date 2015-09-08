package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ d akU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.akU = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        int i;
        View view2;
        view = this.akU.akP;
        if (view != null) {
            int childCount = ((LinearLayout) this.akU.getChildAt(0)).getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    i = 0;
                    break;
                }
                View childAt = ((LinearLayout) this.akU.getChildAt(0)).getChildAt(i2);
                view2 = this.akU.akP;
                if (childAt != view2) {
                    i2++;
                } else {
                    i = childAt.getRight();
                    break;
                }
            }
            this.akU.akP = null;
            int width = i - this.akU.getWidth();
            if (width > 0) {
                this.akU.scrollBy(width, 0);
            }
        }
    }
}
