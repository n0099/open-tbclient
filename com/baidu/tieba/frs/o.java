package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
/* loaded from: classes22.dex */
public class o {
    private View iVj;
    private int iVk = -1;
    private int iVl = -1;

    public o(View view) {
        this.iVj = view;
    }

    public int getOriginHeight() {
        return this.iVk;
    }

    public void setOriginHeight(int i) {
        this.iVk = i;
    }

    public void zL(int i) {
        this.iVl = i;
    }

    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.iVj != null && (layoutParams = this.iVj.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.iVl = i;
            this.iVj.setLayoutParams(layoutParams);
        }
    }

    public void C(double d) {
        if (this.iVj != null) {
            int i = (int) (this.iVk + (PullRefreshFrameLayout.fbv * d));
            ViewGroup.LayoutParams layoutParams = this.iVj.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.iVl = layoutParams.height;
                this.iVj.setLayoutParams(layoutParams);
            }
        }
    }

    public int getHeight() {
        ViewGroup.LayoutParams layoutParams;
        if (this.iVj == null || (layoutParams = this.iVj.getLayoutParams()) == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public int cCW() {
        return this.iVl;
    }
}
