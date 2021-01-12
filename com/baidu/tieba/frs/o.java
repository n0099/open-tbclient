package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
/* loaded from: classes2.dex */
public class o {
    private View jcQ;
    private int jcR = -1;
    private int jcS = -1;

    public o(View view) {
        this.jcQ = view;
    }

    public int getOriginHeight() {
        return this.jcR;
    }

    public void setOriginHeight(int i) {
        this.jcR = i;
    }

    public void ys(int i) {
        this.jcS = i;
    }

    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.jcQ != null && (layoutParams = this.jcQ.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.jcS = i;
            this.jcQ.setLayoutParams(layoutParams);
        }
    }

    public void v(double d) {
        if (this.jcQ != null) {
            int i = (int) (this.jcR + (PullRefreshFrameLayout.fgt * d));
            ViewGroup.LayoutParams layoutParams = this.jcQ.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.jcS = layoutParams.height;
                this.jcQ.setLayoutParams(layoutParams);
            }
        }
    }

    public int getHeight() {
        ViewGroup.LayoutParams layoutParams;
        if (this.jcQ == null || (layoutParams = this.jcQ.getLayoutParams()) == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public int cCa() {
        return this.jcS;
    }
}
