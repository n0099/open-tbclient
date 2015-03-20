package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class at extends com.baidu.adp.widget.ListView.am {
    LinearLayout aKq;
    TextView aKr;
    HeadImageView aKs;
    TextView aKt;
    TextView aKu;
    TextView mTitle;

    public at(View view) {
        super(view);
        this.aKq = (LinearLayout) view.findViewById(com.baidu.tieba.v.app_parent);
        this.mTitle = (TextView) view.findViewById(com.baidu.tieba.v.app_name);
        this.aKt = (TextView) view.findViewById(com.baidu.tieba.v.app_desc);
        this.aKs = (HeadImageView) view.findViewById(com.baidu.tieba.v.app_icon);
        this.aKu = (TextView) view.findViewById(com.baidu.tieba.v.app_download);
        this.aKr = (TextView) view.findViewById(com.baidu.tieba.v.recommend_app);
    }
}
