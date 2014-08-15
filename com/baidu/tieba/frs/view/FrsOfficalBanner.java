package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class FrsOfficalBanner extends LinearLayout {
    View.OnClickListener a;
    private Context b;
    private TextView c;
    private LinearLayout d;
    private com.baidu.tbadk.coreExtra.view.c e;

    public FrsOfficalBanner(Context context) {
        super(context);
        this.a = new j(this);
        a(context);
    }

    public FrsOfficalBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new j(this);
        a(context);
    }

    private void a(Context context) {
        this.b = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.v.frs_offical_banner_view, this);
        this.d = (LinearLayout) findViewById(com.baidu.tieba.u.banner_parent);
        this.c = (TextView) findViewById(com.baidu.tieba.u.tv_text);
        this.d.setOnClickListener(this.a);
    }

    public void setText(String str) {
        this.c.setText(str);
    }

    public void setBannerViewClickListener(com.baidu.tbadk.coreExtra.view.c cVar) {
        this.e = cVar;
    }
}
