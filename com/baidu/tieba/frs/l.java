package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
/* loaded from: classes9.dex */
public class l {
    private View hoU;
    private int hoV = -1;
    private int hoW = -1;

    public l(View view) {
        this.hoU = view;
    }

    public int getOriginHeight() {
        return this.hoV;
    }

    public void setOriginHeight(int i) {
        this.hoV = i;
    }

    public void tL(int i) {
        this.hoW = i;
    }

    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.hoU != null && (layoutParams = this.hoU.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.hoW = i;
            this.hoU.setLayoutParams(layoutParams);
        }
    }

    public void r(double d) {
        if (this.hoU != null) {
            int i = (int) (this.hoV + (PullRefreshFrameLayout.dUU * d));
            ViewGroup.LayoutParams layoutParams = this.hoU.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.hoW = layoutParams.height;
                this.hoU.setLayoutParams(layoutParams);
            }
        }
    }

    public int getHeight() {
        ViewGroup.LayoutParams layoutParams;
        if (this.hoU == null || (layoutParams = this.hoU.getLayoutParams()) == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public int bVE() {
        return this.hoW;
    }
}
