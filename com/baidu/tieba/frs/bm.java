package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class bm extends x.a {
    static final /* synthetic */ boolean $assertionsDisabled;
    public LinearLayout aVA;
    public HeadImageView aVC;
    public TextView aVD;
    public TextView aVE;
    public TextView aVG;
    public TbImageView aVT;
    public TextView aVU;

    static {
        $assertionsDisabled = !bm.class.desiredAssertionStatus();
    }

    public bm(View view) {
        super(view);
        if (!$assertionsDisabled && view == null) {
            throw new AssertionError();
        }
        this.aVA = (LinearLayout) view.findViewById(i.f.frs_app_item_parent);
        this.aVC = (HeadImageView) view.findViewById(i.f.frs_app_icon);
        this.aVD = (TextView) view.findViewById(i.f.frs_app_name);
        this.aVE = (TextView) view.findViewById(i.f.frs_app_time);
        this.aVG = (TextView) view.findViewById(i.f.frs_app_desc);
        this.aVT = (TbImageView) view.findViewById(i.f.frs_app_url);
        this.aVU = (TextView) view.findViewById(i.f.frs_app_download);
    }
}
