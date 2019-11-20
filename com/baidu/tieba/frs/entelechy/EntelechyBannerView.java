package com.baidu.tieba.frs.entelechy;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
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
        if (this.cyW != null && (this.cyW.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cyW.getLayoutParams();
            layoutParams.topMargin = (l.getDimens(getContext(), R.dimen.ds100) - l.dip2px(getContext(), 20.0f)) / 2;
            layoutParams.addRule(10);
            this.cyW.requestLayout();
        }
    }
}
