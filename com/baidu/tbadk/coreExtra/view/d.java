package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c aok;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aok = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        int i;
        View view2;
        view = this.aok.aof;
        if (view != null) {
            int childCount = ((LinearLayout) this.aok.getChildAt(0)).getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    i = 0;
                    break;
                }
                View childAt = ((LinearLayout) this.aok.getChildAt(0)).getChildAt(i2);
                view2 = this.aok.aof;
                if (childAt != view2) {
                    i2++;
                } else {
                    i = childAt.getRight();
                    break;
                }
            }
            this.aok.aof = null;
            int width = i - this.aok.getWidth();
            if (width > 0) {
                this.aok.scrollBy(width, 0);
            }
        }
    }
}
