package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class bc extends x.a {
    static final /* synthetic */ boolean $assertionsDisabled;
    public TextView aWA;
    public LinearLayout aWu;
    public HeadImageView aWv;
    public TextView aWw;
    public TextView aWx;
    public TextView aWy;
    public TbImageView aWz;

    static {
        $assertionsDisabled = !bc.class.desiredAssertionStatus();
    }

    public bc(View view) {
        super(view);
        if (!$assertionsDisabled && view == null) {
            throw new AssertionError();
        }
        this.aWu = (LinearLayout) view.findViewById(i.f.frs_app_item_parent);
        this.aWv = (HeadImageView) view.findViewById(i.f.frs_app_icon);
        this.aWw = (TextView) view.findViewById(i.f.frs_app_name);
        this.aWx = (TextView) view.findViewById(i.f.frs_app_time);
        this.aWy = (TextView) view.findViewById(i.f.frs_app_desc);
        this.aWz = (TbImageView) view.findViewById(i.f.frs_app_url);
        this.aWA = (TextView) view.findViewById(i.f.frs_app_download);
    }
}
