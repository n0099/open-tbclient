package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ d amK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.amK = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        int i;
        View view2;
        view = this.amK.amF;
        if (view != null) {
            int childCount = ((LinearLayout) this.amK.getChildAt(0)).getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    i = 0;
                    break;
                }
                View childAt = ((LinearLayout) this.amK.getChildAt(0)).getChildAt(i2);
                view2 = this.amK.amF;
                if (childAt != view2) {
                    i2++;
                } else {
                    i = childAt.getRight();
                    break;
                }
            }
            this.amK.amF = null;
            int width = i - this.amK.getWidth();
            if (width > 0) {
                this.amK.scrollBy(width, 0);
            }
        }
    }
}
