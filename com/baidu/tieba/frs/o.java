package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
/* loaded from: classes2.dex */
public class o {
    private View jix;
    private int jiy = -1;
    private int jiz = -1;

    public o(View view) {
        this.jix = view;
    }

    public int getOriginHeight() {
        return this.jiy;
    }

    public void setOriginHeight(int i) {
        this.jiy = i;
    }

    public void yC(int i) {
        this.jiz = i;
    }

    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.jix != null && (layoutParams = this.jix.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.jiz = i;
            this.jix.setLayoutParams(layoutParams);
        }
    }

    public void v(double d) {
        if (this.jix != null) {
            int i = (int) (this.jiy + (PullRefreshFrameLayout.fiM * d));
            ViewGroup.LayoutParams layoutParams = this.jix.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.jiz = layoutParams.height;
                this.jix.setLayoutParams(layoutParams);
            }
        }
    }

    public int getHeight() {
        ViewGroup.LayoutParams layoutParams;
        if (this.jix == null || (layoutParams = this.jix.getLayoutParams()) == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public int cDm() {
        return this.jiz;
    }
}
