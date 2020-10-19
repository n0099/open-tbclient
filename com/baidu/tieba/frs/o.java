package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
/* loaded from: classes22.dex */
public class o {
    private View irk;
    private int irl = -1;
    private int irm = -1;

    public o(View view) {
        this.irk = view;
    }

    public int getOriginHeight() {
        return this.irl;
    }

    public void setOriginHeight(int i) {
        this.irl = i;
    }

    public void yc(int i) {
        this.irm = i;
    }

    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.irk != null && (layoutParams = this.irk.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.irm = i;
            this.irk.setLayoutParams(layoutParams);
        }
    }

    public void A(double d) {
        if (this.irk != null) {
            int i = (int) (this.irl + (PullRefreshFrameLayout.eGF * d));
            ViewGroup.LayoutParams layoutParams = this.irk.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.irm = layoutParams.height;
                this.irk.setLayoutParams(layoutParams);
            }
        }
    }

    public int getHeight() {
        ViewGroup.LayoutParams layoutParams;
        if (this.irk == null || (layoutParams = this.irk.getLayoutParams()) == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public int ctu() {
        return this.irm;
    }
}
