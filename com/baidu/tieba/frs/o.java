package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
/* loaded from: classes2.dex */
public class o {
    private View jku;
    private int jkv = -1;
    private int jkw = -1;

    public o(View view) {
        this.jku = view;
    }

    public int getOriginHeight() {
        return this.jkv;
    }

    public void setOriginHeight(int i) {
        this.jkv = i;
    }

    public void yD(int i) {
        this.jkw = i;
    }

    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.jku != null && (layoutParams = this.jku.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.jkw = i;
            this.jku.setLayoutParams(layoutParams);
        }
    }

    public void v(double d) {
        if (this.jku != null) {
            int i = (int) (this.jkv + (PullRefreshFrameLayout.fkl * d));
            ViewGroup.LayoutParams layoutParams = this.jku.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.jkw = layoutParams.height;
                this.jku.setLayoutParams(layoutParams);
            }
        }
    }

    public int getHeight() {
        ViewGroup.LayoutParams layoutParams;
        if (this.jku == null || (layoutParams = this.jku.getLayoutParams()) == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public int cDz() {
        return this.jkw;
    }
}
