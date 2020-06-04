package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
/* loaded from: classes9.dex */
public class l {
    private View hpf;
    private int hpg = -1;
    private int hph = -1;

    public l(View view) {
        this.hpf = view;
    }

    public int getOriginHeight() {
        return this.hpg;
    }

    public void setOriginHeight(int i) {
        this.hpg = i;
    }

    public void tN(int i) {
        this.hph = i;
    }

    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.hpf != null && (layoutParams = this.hpf.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.hph = i;
            this.hpf.setLayoutParams(layoutParams);
        }
    }

    public void r(double d) {
        if (this.hpf != null) {
            int i = (int) (this.hpg + (PullRefreshFrameLayout.dUU * d));
            ViewGroup.LayoutParams layoutParams = this.hpf.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.hph = layoutParams.height;
                this.hpf.setLayoutParams(layoutParams);
            }
        }
    }

    public int getHeight() {
        ViewGroup.LayoutParams layoutParams;
        if (this.hpf == null || (layoutParams = this.hpf.getLayoutParams()) == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public int bVG() {
        return this.hph;
    }
}
