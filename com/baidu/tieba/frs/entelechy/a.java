package com.baidu.tieba.frs.entelechy;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a extends BannerView {
    public a(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (this.ajV != null && (this.ajV.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ajV.getLayoutParams();
            layoutParams.topMargin = (com.baidu.adp.lib.util.k.c(getContext(), u.e.ds100) - com.baidu.adp.lib.util.k.dip2px(getContext(), 20.0f)) / 2;
            layoutParams.addRule(10);
            this.ajV.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView
    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        ViewGroup.LayoutParams layoutParams;
        super.a(tbPageContext, str, str2);
        if (this.ajW != null && (layoutParams = this.ajW.getLayoutParams()) != null) {
            layoutParams.height = com.baidu.adp.lib.util.k.c(getContext(), u.e.ds100);
        }
    }
}
