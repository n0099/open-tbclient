package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ d alE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.alE = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        int i;
        View view2;
        view = this.alE.alz;
        if (view != null) {
            int childCount = ((LinearLayout) this.alE.getChildAt(0)).getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    i = 0;
                    break;
                }
                View childAt = ((LinearLayout) this.alE.getChildAt(0)).getChildAt(i2);
                view2 = this.alE.alz;
                if (childAt != view2) {
                    i2++;
                } else {
                    i = childAt.getRight();
                    break;
                }
            }
            this.alE.alz = null;
            int width = i - this.alE.getWidth();
            if (width > 0) {
                this.alE.scrollBy(width, 0);
            }
        }
    }
}
