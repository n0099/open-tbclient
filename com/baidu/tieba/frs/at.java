package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class at extends com.baidu.adp.widget.ListView.am {
    LinearLayout aKA;
    TextView aKB;
    HeadImageView aKC;
    TextView aKD;
    TextView aKE;
    TextView mTitle;

    public at(View view) {
        super(view);
        this.aKA = (LinearLayout) view.findViewById(com.baidu.tieba.v.app_parent);
        this.mTitle = (TextView) view.findViewById(com.baidu.tieba.v.app_name);
        this.aKD = (TextView) view.findViewById(com.baidu.tieba.v.app_desc);
        this.aKC = (HeadImageView) view.findViewById(com.baidu.tieba.v.app_icon);
        this.aKE = (TextView) view.findViewById(com.baidu.tieba.v.app_download);
        this.aKB = (TextView) view.findViewById(com.baidu.tieba.v.recommend_app);
    }
}
