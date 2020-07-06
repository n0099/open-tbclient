package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
/* loaded from: classes9.dex */
public class n {
    private View hBP;
    private int hBQ = -1;
    private int hBR = -1;

    public n(View view) {
        this.hBP = view;
    }

    public int getOriginHeight() {
        return this.hBQ;
    }

    public void setOriginHeight(int i) {
        this.hBQ = i;
    }

    public void uq(int i) {
        this.hBR = i;
    }

    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.hBP != null && (layoutParams = this.hBP.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.hBR = i;
            this.hBP.setLayoutParams(layoutParams);
        }
    }

    public void r(double d) {
        if (this.hBP != null) {
            int i = (int) (this.hBQ + (PullRefreshFrameLayout.ecl * d));
            ViewGroup.LayoutParams layoutParams = this.hBP.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.hBR = layoutParams.height;
                this.hBP.setLayoutParams(layoutParams);
            }
        }
    }

    public int getHeight() {
        ViewGroup.LayoutParams layoutParams;
        if (this.hBP == null || (layoutParams = this.hBP.getLayoutParams()) == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public int bYP() {
        return this.hBR;
    }
}
