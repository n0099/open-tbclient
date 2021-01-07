package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
/* loaded from: classes2.dex */
public class o {
    private View jhx;
    private int jhy = -1;
    private int jhz = -1;

    public o(View view) {
        this.jhx = view;
    }

    public int getOriginHeight() {
        return this.jhy;
    }

    public void setOriginHeight(int i) {
        this.jhy = i;
    }

    public void zY(int i) {
        this.jhz = i;
    }

    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.jhx != null && (layoutParams = this.jhx.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.jhz = i;
            this.jhx.setLayoutParams(layoutParams);
        }
    }

    public void B(double d) {
        if (this.jhx != null) {
            int i = (int) (this.jhy + (PullRefreshFrameLayout.fle * d));
            ViewGroup.LayoutParams layoutParams = this.jhx.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.jhz = layoutParams.height;
                this.jhx.setLayoutParams(layoutParams);
            }
        }
    }

    public int getHeight() {
        ViewGroup.LayoutParams layoutParams;
        if (this.jhx == null || (layoutParams = this.jhx.getLayoutParams()) == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public int cFS() {
        return this.jhz;
    }
}
