package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
/* loaded from: classes9.dex */
public class l {
    private View hag;
    private int hah = -1;
    private int hai = -1;

    public l(View view) {
        this.hag = view;
    }

    public int getOriginHeight() {
        return this.hah;
    }

    public void setOriginHeight(int i) {
        this.hah = i;
    }

    public void tg(int i) {
        this.hai = i;
    }

    public void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (this.hag != null && (layoutParams = this.hag.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.hai = i;
            this.hag.setLayoutParams(layoutParams);
        }
    }

    public void q(double d) {
        if (this.hag != null) {
            int i = (int) (this.hah + (PullRefreshFrameLayout.dGI * d));
            ViewGroup.LayoutParams layoutParams = this.hag.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.hai = layoutParams.height;
                this.hag.setLayoutParams(layoutParams);
            }
        }
    }

    public int getHeight() {
        ViewGroup.LayoutParams layoutParams;
        if (this.hag == null || (layoutParams = this.hag.getLayoutParams()) == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public int bPh() {
        return this.hai;
    }
}
