package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class at extends com.baidu.adp.widget.ListView.am {
    LinearLayout aMH;
    TextView aMI;
    HeadImageView aMJ;
    TextView aMK;
    TextView aML;
    TextView mTitle;

    public at(View view) {
        super(view);
        this.aMH = (LinearLayout) view.findViewById(com.baidu.tieba.q.app_parent);
        this.mTitle = (TextView) view.findViewById(com.baidu.tieba.q.app_name);
        this.aMK = (TextView) view.findViewById(com.baidu.tieba.q.app_desc);
        this.aMJ = (HeadImageView) view.findViewById(com.baidu.tieba.q.app_icon);
        this.aML = (TextView) view.findViewById(com.baidu.tieba.q.app_download);
        this.aMI = (TextView) view.findViewById(com.baidu.tieba.q.recommend_app);
    }
}
