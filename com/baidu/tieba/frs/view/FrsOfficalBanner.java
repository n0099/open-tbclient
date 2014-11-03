package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class FrsOfficalBanner extends LinearLayout {
    View.OnClickListener NA;
    private com.baidu.tbadk.coreExtra.view.b Nz;
    private TextView aGg;
    private LinearLayout aGh;
    private Context mContext;

    public FrsOfficalBanner(Context context) {
        super(context);
        this.NA = new n(this);
        init(context);
    }

    public FrsOfficalBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.NA = new n(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.ek().inflate(context, com.baidu.tieba.w.frs_offical_banner_view, this);
        this.aGh = (LinearLayout) findViewById(com.baidu.tieba.v.banner_parent);
        this.aGg = (TextView) findViewById(com.baidu.tieba.v.tv_text);
        this.aGh.setOnClickListener(this.NA);
    }

    public void setText(String str) {
        this.aGg.setText(str);
    }

    public void setBannerViewClickListener(com.baidu.tbadk.coreExtra.view.b bVar) {
        this.Nz = bVar;
    }
}
