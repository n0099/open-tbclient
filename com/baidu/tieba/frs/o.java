package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
/* loaded from: classes22.dex */
public class o {
    private View iJD;
    private int iJE = -1;
    private int iJF = -1;

    public o(View view) {
        this.iJD = view;
    }

    public int getOriginHeight() {
        return this.iJE;
    }

    public void setOriginHeight(int i) {
        this.iJE = i;
    }

    public void yI(int i) {
        this.iJF = i;
    }

    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.iJD != null && (layoutParams = this.iJD.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.iJF = i;
            this.iJD.setLayoutParams(layoutParams);
        }
    }

    public void B(double d) {
        if (this.iJD != null) {
            int i = (int) (this.iJE + (PullRefreshFrameLayout.eUQ * d));
            ViewGroup.LayoutParams layoutParams = this.iJD.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.iJF = layoutParams.height;
                this.iJD.setLayoutParams(layoutParams);
            }
        }
    }

    public int getHeight() {
        ViewGroup.LayoutParams layoutParams;
        if (this.iJD == null || (layoutParams = this.iJD.getLayoutParams()) == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public int czc() {
        return this.iJF;
    }
}
