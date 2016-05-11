package com.baidu.tieba.frs.entelechy;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends BannerView {
    public a(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (this.ajp != null && (this.ajp.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ajp.getLayoutParams();
            layoutParams.topMargin = (com.baidu.adp.lib.util.k.c(getContext(), t.e.frs_header_banner_height) - com.baidu.adp.lib.util.k.dip2px(getContext(), 20.0f)) / 2;
            layoutParams.addRule(10);
            this.ajp.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView
    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        ViewGroup.LayoutParams layoutParams;
        super.a(tbPageContext, str, str2);
        if (this.ajq != null && (layoutParams = this.ajq.getLayoutParams()) != null) {
            layoutParams.height = com.baidu.adp.lib.util.k.c(getContext(), t.e.frs_header_banner_height);
        }
    }
}
