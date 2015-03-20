package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class au extends com.baidu.adp.widget.ListView.am {
    static final /* synthetic */ boolean $assertionsDisabled;
    TbImageView aKA;
    TextView aKB;
    LinearLayout aKv;
    HeadImageView aKw;
    TextView aKx;
    TextView aKy;
    TextView aKz;

    static {
        $assertionsDisabled = !au.class.desiredAssertionStatus();
    }

    public au(View view) {
        super(view);
        if (!$assertionsDisabled && view == null) {
            throw new AssertionError();
        }
        this.aKv = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_app_item_parent);
        this.aKw = (HeadImageView) view.findViewById(com.baidu.tieba.v.frs_app_icon);
        this.aKx = (TextView) view.findViewById(com.baidu.tieba.v.frs_app_name);
        this.aKy = (TextView) view.findViewById(com.baidu.tieba.v.frs_app_time);
        this.aKz = (TextView) view.findViewById(com.baidu.tieba.v.frs_app_desc);
        this.aKA = (TbImageView) view.findViewById(com.baidu.tieba.v.frs_app_url);
        this.aKB = (TextView) view.findViewById(com.baidu.tieba.v.frs_app_download);
    }
}
