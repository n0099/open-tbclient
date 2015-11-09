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
    public LinearLayout aVT;
    public HeadImageView aVV;
    public TextView aVW;
    public TextView aVX;
    public TextView aVZ;
    public TbImageView aWm;
    public TextView aWn;

    static {
        $assertionsDisabled = !bm.class.desiredAssertionStatus();
    }

    public bm(View view) {
        super(view);
        if (!$assertionsDisabled && view == null) {
            throw new AssertionError();
        }
        this.aVT = (LinearLayout) view.findViewById(i.f.frs_app_item_parent);
        this.aVV = (HeadImageView) view.findViewById(i.f.frs_app_icon);
        this.aVW = (TextView) view.findViewById(i.f.frs_app_name);
        this.aVX = (TextView) view.findViewById(i.f.frs_app_time);
        this.aVZ = (TextView) view.findViewById(i.f.frs_app_desc);
        this.aWm = (TbImageView) view.findViewById(i.f.frs_app_url);
        this.aWn = (TextView) view.findViewById(i.f.frs_app_download);
    }
}
