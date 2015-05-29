package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class au extends com.baidu.adp.widget.ListView.am {
    static final /* synthetic */ boolean $assertionsDisabled;
    LinearLayout aMM;
    HeadImageView aMN;
    TextView aMO;
    TextView aMP;
    TextView aMQ;
    TbImageView aMR;
    TextView aMS;

    static {
        $assertionsDisabled = !au.class.desiredAssertionStatus();
    }

    public au(View view) {
        super(view);
        if (!$assertionsDisabled && view == null) {
            throw new AssertionError();
        }
        this.aMM = (LinearLayout) view.findViewById(com.baidu.tieba.q.frs_app_item_parent);
        this.aMN = (HeadImageView) view.findViewById(com.baidu.tieba.q.frs_app_icon);
        this.aMO = (TextView) view.findViewById(com.baidu.tieba.q.frs_app_name);
        this.aMP = (TextView) view.findViewById(com.baidu.tieba.q.frs_app_time);
        this.aMQ = (TextView) view.findViewById(com.baidu.tieba.q.frs_app_desc);
        this.aMR = (TbImageView) view.findViewById(com.baidu.tieba.q.frs_app_url);
        this.aMS = (TextView) view.findViewById(com.baidu.tieba.q.frs_app_download);
    }
}
