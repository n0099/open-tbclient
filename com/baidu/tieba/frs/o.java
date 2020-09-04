package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
/* loaded from: classes16.dex */
public class o {
    private View hVj;
    private int hVk = -1;
    private int hVl = -1;

    public o(View view) {
        this.hVj = view;
    }

    public int getOriginHeight() {
        return this.hVk;
    }

    public void setOriginHeight(int i) {
        this.hVk = i;
    }

    public void wX(int i) {
        this.hVl = i;
    }

    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.hVj != null && (layoutParams = this.hVj.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.hVl = i;
            this.hVj.setLayoutParams(layoutParams);
        }
    }

    public void x(double d) {
        if (this.hVj != null) {
            int i = (int) (this.hVk + (PullRefreshFrameLayout.esq * d));
            ViewGroup.LayoutParams layoutParams = this.hVj.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.hVl = layoutParams.height;
                this.hVj.setLayoutParams(layoutParams);
            }
        }
    }

    public int getHeight() {
        ViewGroup.LayoutParams layoutParams;
        if (this.hVj == null || (layoutParams = this.hVj.getLayoutParams()) == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public int cmK() {
        return this.hVl;
    }
}
