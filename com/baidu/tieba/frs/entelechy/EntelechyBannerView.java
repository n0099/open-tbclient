package com.baidu.tieba.frs.entelechy;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class EntelechyBannerView extends BannerView {
    public EntelechyBannerView(Context context) {
        super(context);
        l();
    }

    public final void l() {
        Button button = this.f13737g;
        if (button == null || !(button.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f13737g.getLayoutParams();
        layoutParams.topMargin = (l.g(getContext(), R.dimen.ds100) - l.e(getContext(), 20.0f)) / 2;
        layoutParams.addRule(10);
        this.f13737g.requestLayout();
    }

    public EntelechyBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        l();
    }
}
