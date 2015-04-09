package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class au extends com.baidu.adp.widget.ListView.am {
    static final /* synthetic */ boolean $assertionsDisabled;
    LinearLayout aKF;
    HeadImageView aKG;
    TextView aKH;
    TextView aKI;
    TextView aKJ;
    TbImageView aKK;
    TextView aKL;

    static {
        $assertionsDisabled = !au.class.desiredAssertionStatus();
    }

    public au(View view) {
        super(view);
        if (!$assertionsDisabled && view == null) {
            throw new AssertionError();
        }
        this.aKF = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_app_item_parent);
        this.aKG = (HeadImageView) view.findViewById(com.baidu.tieba.v.frs_app_icon);
        this.aKH = (TextView) view.findViewById(com.baidu.tieba.v.frs_app_name);
        this.aKI = (TextView) view.findViewById(com.baidu.tieba.v.frs_app_time);
        this.aKJ = (TextView) view.findViewById(com.baidu.tieba.v.frs_app_desc);
        this.aKK = (TbImageView) view.findViewById(com.baidu.tieba.v.frs_app_url);
        this.aKL = (TextView) view.findViewById(com.baidu.tieba.v.frs_app_download);
    }
}
