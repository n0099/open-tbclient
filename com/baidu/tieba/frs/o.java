package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
/* loaded from: classes2.dex */
public class o {
    private View jiL;
    private int jiM = -1;
    private int jiN = -1;

    public o(View view) {
        this.jiL = view;
    }

    public int getOriginHeight() {
        return this.jiM;
    }

    public void setOriginHeight(int i) {
        this.jiM = i;
    }

    public void yC(int i) {
        this.jiN = i;
    }

    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.jiL != null && (layoutParams = this.jiL.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.jiN = i;
            this.jiL.setLayoutParams(layoutParams);
        }
    }

    public void v(double d) {
        if (this.jiL != null) {
            int i = (int) (this.jiM + (PullRefreshFrameLayout.fiM * d));
            ViewGroup.LayoutParams layoutParams = this.jiL.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.jiN = layoutParams.height;
                this.jiL.setLayoutParams(layoutParams);
            }
        }
    }

    public int getHeight() {
        ViewGroup.LayoutParams layoutParams;
        if (this.jiL == null || (layoutParams = this.jiL.getLayoutParams()) == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public int cDt() {
        return this.jiN;
    }
}
