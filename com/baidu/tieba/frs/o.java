package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
/* loaded from: classes21.dex */
public class o {
    private View iKq;
    private int iKr = -1;
    private int iKs = -1;

    public o(View view) {
        this.iKq = view;
    }

    public int getOriginHeight() {
        return this.iKr;
    }

    public void setOriginHeight(int i) {
        this.iKr = i;
    }

    public void zg(int i) {
        this.iKs = i;
    }

    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.iKq != null && (layoutParams = this.iKq.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.iKs = i;
            this.iKq.setLayoutParams(layoutParams);
        }
    }

    public void B(double d) {
        if (this.iKq != null) {
            int i = (int) (this.iKr + (PullRefreshFrameLayout.eTY * d));
            ViewGroup.LayoutParams layoutParams = this.iKq.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.iKs = layoutParams.height;
                this.iKq.setLayoutParams(layoutParams);
            }
        }
    }

    public int getHeight() {
        ViewGroup.LayoutParams layoutParams;
        if (this.iKq == null || (layoutParams = this.iKq.getLayoutParams()) == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public int cyF() {
        return this.iKs;
    }
}
