package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
/* loaded from: classes22.dex */
public class o {
    private View iDG;
    private int iDH = -1;
    private int iDI = -1;

    public o(View view) {
        this.iDG = view;
    }

    public int getOriginHeight() {
        return this.iDH;
    }

    public void setOriginHeight(int i) {
        this.iDH = i;
    }

    public void yv(int i) {
        this.iDI = i;
    }

    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.iDG != null && (layoutParams = this.iDG.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.iDI = i;
            this.iDG.setLayoutParams(layoutParams);
        }
    }

    public void B(double d) {
        if (this.iDG != null) {
            int i = (int) (this.iDH + (PullRefreshFrameLayout.ePb * d));
            ViewGroup.LayoutParams layoutParams = this.iDG.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.iDI = layoutParams.height;
                this.iDG.setLayoutParams(layoutParams);
            }
        }
    }

    public int getHeight() {
        ViewGroup.LayoutParams layoutParams;
        if (this.iDG == null || (layoutParams = this.iDG.getLayoutParams()) == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public int cwB() {
        return this.iDI;
    }
}
