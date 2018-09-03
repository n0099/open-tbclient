package com.baidu.tieba.frs.entelechy;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class EntelechyBannerView extends BannerView {
    public EntelechyBannerView(Context context) {
        super(context);
        init();
    }

    public EntelechyBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        if (this.aGK != null && (this.aGK.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aGK.getLayoutParams();
            layoutParams.topMargin = (l.f(getContext(), f.e.ds100) - l.dip2px(getContext(), 20.0f)) / 2;
            layoutParams.addRule(10);
            this.aGK.requestLayout();
        }
    }
}
