package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
/* loaded from: classes16.dex */
public class o {
    private View hVd;
    private int hVe = -1;
    private int hVf = -1;

    public o(View view) {
        this.hVd = view;
    }

    public int getOriginHeight() {
        return this.hVe;
    }

    public void setOriginHeight(int i) {
        this.hVe = i;
    }

    public void wX(int i) {
        this.hVf = i;
    }

    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.hVd != null && (layoutParams = this.hVd.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.hVf = i;
            this.hVd.setLayoutParams(layoutParams);
        }
    }

    public void x(double d) {
        if (this.hVd != null) {
            int i = (int) (this.hVe + (PullRefreshFrameLayout.esm * d));
            ViewGroup.LayoutParams layoutParams = this.hVd.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.hVf = layoutParams.height;
                this.hVd.setLayoutParams(layoutParams);
            }
        }
    }

    public int getHeight() {
        ViewGroup.LayoutParams layoutParams;
        if (this.hVd == null || (layoutParams = this.hVd.getLayoutParams()) == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public int cmJ() {
        return this.hVf;
    }
}
