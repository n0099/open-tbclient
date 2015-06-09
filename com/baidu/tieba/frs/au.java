package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class au extends com.baidu.adp.widget.ListView.am {
    static final /* synthetic */ boolean $assertionsDisabled;
    LinearLayout aMN;
    HeadImageView aMO;
    TextView aMP;
    TextView aMQ;
    TextView aMR;
    TbImageView aMS;
    TextView aMT;

    static {
        $assertionsDisabled = !au.class.desiredAssertionStatus();
    }

    public au(View view) {
        super(view);
        if (!$assertionsDisabled && view == null) {
            throw new AssertionError();
        }
        this.aMN = (LinearLayout) view.findViewById(com.baidu.tieba.q.frs_app_item_parent);
        this.aMO = (HeadImageView) view.findViewById(com.baidu.tieba.q.frs_app_icon);
        this.aMP = (TextView) view.findViewById(com.baidu.tieba.q.frs_app_name);
        this.aMQ = (TextView) view.findViewById(com.baidu.tieba.q.frs_app_time);
        this.aMR = (TextView) view.findViewById(com.baidu.tieba.q.frs_app_desc);
        this.aMS = (TbImageView) view.findViewById(com.baidu.tieba.q.frs_app_url);
        this.aMT = (TextView) view.findViewById(com.baidu.tieba.q.frs_app_download);
    }
}
