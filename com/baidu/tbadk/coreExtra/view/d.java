package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c aoM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aoM = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        int i;
        View view2;
        view = this.aoM.aoH;
        if (view != null) {
            int childCount = ((LinearLayout) this.aoM.getChildAt(0)).getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    i = 0;
                    break;
                }
                View childAt = ((LinearLayout) this.aoM.getChildAt(0)).getChildAt(i2);
                view2 = this.aoM.aoH;
                if (childAt != view2) {
                    i2++;
                } else {
                    i = childAt.getRight();
                    break;
                }
            }
            this.aoM.aoH = null;
            int width = i - this.aoM.getWidth();
            if (width > 0) {
                this.aoM.scrollBy(width, 0);
            }
        }
    }
}
