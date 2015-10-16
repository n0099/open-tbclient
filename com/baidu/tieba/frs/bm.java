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
    public LinearLayout aVL;
    public HeadImageView aVN;
    public TextView aVO;
    public TextView aVP;
    public TextView aVR;
    public TbImageView aWe;
    public TextView aWf;

    static {
        $assertionsDisabled = !bm.class.desiredAssertionStatus();
    }

    public bm(View view) {
        super(view);
        if (!$assertionsDisabled && view == null) {
            throw new AssertionError();
        }
        this.aVL = (LinearLayout) view.findViewById(i.f.frs_app_item_parent);
        this.aVN = (HeadImageView) view.findViewById(i.f.frs_app_icon);
        this.aVO = (TextView) view.findViewById(i.f.frs_app_name);
        this.aVP = (TextView) view.findViewById(i.f.frs_app_time);
        this.aVR = (TextView) view.findViewById(i.f.frs_app_desc);
        this.aWe = (TbImageView) view.findViewById(i.f.frs_app_url);
        this.aWf = (TextView) view.findViewById(i.f.frs_app_download);
    }
}
