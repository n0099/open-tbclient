package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class bb extends x.a {
    static final /* synthetic */ boolean $assertionsDisabled;
    public LinearLayout aWd;
    public HeadImageView aWe;
    public TextView aWf;
    public TextView aWg;
    public TextView aWh;
    public TbImageView aWi;
    public TextView aWj;

    static {
        $assertionsDisabled = !bb.class.desiredAssertionStatus();
    }

    public bb(View view) {
        super(view);
        if (!$assertionsDisabled && view == null) {
            throw new AssertionError();
        }
        this.aWd = (LinearLayout) view.findViewById(i.f.frs_app_item_parent);
        this.aWe = (HeadImageView) view.findViewById(i.f.frs_app_icon);
        this.aWf = (TextView) view.findViewById(i.f.frs_app_name);
        this.aWg = (TextView) view.findViewById(i.f.frs_app_time);
        this.aWh = (TextView) view.findViewById(i.f.frs_app_desc);
        this.aWi = (TbImageView) view.findViewById(i.f.frs_app_url);
        this.aWj = (TextView) view.findViewById(i.f.frs_app_download);
    }
}
