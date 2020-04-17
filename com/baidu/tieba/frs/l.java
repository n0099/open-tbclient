package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
/* loaded from: classes9.dex */
public class l {
    private View haa;
    private int hab = -1;
    private int hac = -1;

    public l(View view) {
        this.haa = view;
    }

    public int getOriginHeight() {
        return this.hab;
    }

    public void setOriginHeight(int i) {
        this.hab = i;
    }

    public void tg(int i) {
        this.hac = i;
    }

    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.haa != null && (layoutParams = this.haa.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.hac = i;
            this.haa.setLayoutParams(layoutParams);
        }
    }

    public void q(double d) {
        if (this.haa != null) {
            int i = (int) (this.hab + (PullRefreshFrameLayout.dGE * d));
            ViewGroup.LayoutParams layoutParams = this.haa.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.hac = layoutParams.height;
                this.haa.setLayoutParams(layoutParams);
            }
        }
    }

    public int getHeight() {
        ViewGroup.LayoutParams layoutParams;
        if (this.haa == null || (layoutParams = this.haa.getLayoutParams()) == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public int bPj() {
        return this.hac;
    }
}
