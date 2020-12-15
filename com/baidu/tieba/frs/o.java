package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
/* loaded from: classes22.dex */
public class o {
    private View iVl;
    private int iVm = -1;
    private int iVn = -1;

    public o(View view) {
        this.iVl = view;
    }

    public int getOriginHeight() {
        return this.iVm;
    }

    public void setOriginHeight(int i) {
        this.iVm = i;
    }

    public void zL(int i) {
        this.iVn = i;
    }

    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.iVl != null && (layoutParams = this.iVl.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.iVn = i;
            this.iVl.setLayoutParams(layoutParams);
        }
    }

    public void C(double d) {
        if (this.iVl != null) {
            int i = (int) (this.iVm + (PullRefreshFrameLayout.fbv * d));
            ViewGroup.LayoutParams layoutParams = this.iVl.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.iVn = layoutParams.height;
                this.iVl.setLayoutParams(layoutParams);
            }
        }
    }

    public int getHeight() {
        ViewGroup.LayoutParams layoutParams;
        if (this.iVl == null || (layoutParams = this.iVl.getLayoutParams()) == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public int cCX() {
        return this.iVn;
    }
}
