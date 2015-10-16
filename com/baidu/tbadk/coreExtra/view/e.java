package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ d ajO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.ajO = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        int i;
        View view2;
        view = this.ajO.ajJ;
        if (view != null) {
            int childCount = ((LinearLayout) this.ajO.getChildAt(0)).getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    i = 0;
                    break;
                }
                View childAt = ((LinearLayout) this.ajO.getChildAt(0)).getChildAt(i2);
                view2 = this.ajO.ajJ;
                if (childAt != view2) {
                    i2++;
                } else {
                    i = childAt.getRight();
                    break;
                }
            }
            this.ajO.ajJ = null;
            int width = i - this.ajO.getWidth();
            if (width > 0) {
                this.ajO.scrollBy(width, 0);
            }
        }
    }
}
