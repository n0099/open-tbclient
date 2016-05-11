package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c ajI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.ajI = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        int i;
        View view2;
        view = this.ajI.ajD;
        if (view != null) {
            int childCount = ((LinearLayout) this.ajI.getChildAt(0)).getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    i = 0;
                    break;
                }
                View childAt = ((LinearLayout) this.ajI.getChildAt(0)).getChildAt(i2);
                view2 = this.ajI.ajD;
                if (childAt != view2) {
                    i2++;
                } else {
                    i = childAt.getRight();
                    break;
                }
            }
            this.ajI.ajD = null;
            int width = i - this.ajI.getWidth();
            if (width > 0) {
                this.ajI.scrollBy(width, 0);
            }
        }
    }
}
