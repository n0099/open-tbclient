package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ d akC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.akC = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        int i;
        View view2;
        view = this.akC.akx;
        if (view != null) {
            int childCount = ((LinearLayout) this.akC.getChildAt(0)).getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    i = 0;
                    break;
                }
                View childAt = ((LinearLayout) this.akC.getChildAt(0)).getChildAt(i2);
                view2 = this.akC.akx;
                if (childAt != view2) {
                    i2++;
                } else {
                    i = childAt.getRight();
                    break;
                }
            }
            this.akC.akx = null;
            int width = i - this.akC.getWidth();
            if (width > 0) {
                this.akC.scrollBy(width, 0);
            }
        }
    }
}
