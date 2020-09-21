package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
/* loaded from: classes21.dex */
public class o {
    private View icj;
    private int ick = -1;
    private int icl = -1;

    public o(View view) {
        this.icj = view;
    }

    public int getOriginHeight() {
        return this.ick;
    }

    public void setOriginHeight(int i) {
        this.ick = i;
    }

    public void xw(int i) {
        this.icl = i;
    }

    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.icj != null && (layoutParams = this.icj.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.icl = i;
            this.icj.setLayoutParams(layoutParams);
        }
    }

    public void x(double d) {
        if (this.icj != null) {
            int i = (int) (this.ick + (PullRefreshFrameLayout.euv * d));
            ViewGroup.LayoutParams layoutParams = this.icj.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.icl = layoutParams.height;
                this.icj.setLayoutParams(layoutParams);
            }
        }
    }

    public int getHeight() {
        ViewGroup.LayoutParams layoutParams;
        if (this.icj == null || (layoutParams = this.icj.getLayoutParams()) == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public int cpW() {
        return this.icl;
    }
}
