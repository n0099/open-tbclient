package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
/* loaded from: classes16.dex */
public class n {
    private View hHN;
    private int hHO = -1;
    private int hHP = -1;

    public n(View view) {
        this.hHN = view;
    }

    public int getOriginHeight() {
        return this.hHO;
    }

    public void setOriginHeight(int i) {
        this.hHO = i;
    }

    public void uI(int i) {
        this.hHP = i;
    }

    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.hHN != null && (layoutParams = this.hHN.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.hHP = i;
            this.hHN.setLayoutParams(layoutParams);
        }
    }

    public void r(double d) {
        if (this.hHN != null) {
            int i = (int) (this.hHO + (PullRefreshFrameLayout.eiv * d));
            ViewGroup.LayoutParams layoutParams = this.hHN.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.hHP = layoutParams.height;
                this.hHN.setLayoutParams(layoutParams);
            }
        }
    }

    public int getHeight() {
        ViewGroup.LayoutParams layoutParams;
        if (this.hHN == null || (layoutParams = this.hHN.getLayoutParams()) == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public int ccm() {
        return this.hHP;
    }
}
