package com.baidu.tieba.frs.entelechy;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a extends BannerView {
    public a(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (this.akK != null && (this.akK.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.akK.getLayoutParams();
            layoutParams.topMargin = (com.baidu.adp.lib.util.k.c(getContext(), u.e.ds100) - com.baidu.adp.lib.util.k.dip2px(getContext(), 20.0f)) / 2;
            layoutParams.addRule(10);
            this.akK.requestLayout();
        }
    }
}
