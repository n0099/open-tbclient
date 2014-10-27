package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class FrsOfficalBanner extends LinearLayout {
    private com.baidu.tbadk.coreExtra.view.b Nv;
    View.OnClickListener Nw;
    private TextView aFW;
    private LinearLayout aFX;
    private Context mContext;

    public FrsOfficalBanner(Context context) {
        super(context);
        this.Nw = new n(this);
        init(context);
    }

    public FrsOfficalBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Nw = new n(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.ek().inflate(context, com.baidu.tieba.w.frs_offical_banner_view, this);
        this.aFX = (LinearLayout) findViewById(com.baidu.tieba.v.banner_parent);
        this.aFW = (TextView) findViewById(com.baidu.tieba.v.tv_text);
        this.aFX.setOnClickListener(this.Nw);
    }

    public void setText(String str) {
        this.aFW.setText(str);
    }

    public void setBannerViewClickListener(com.baidu.tbadk.coreExtra.view.b bVar) {
        this.Nv = bVar;
    }
}
