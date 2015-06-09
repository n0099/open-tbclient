package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class at extends com.baidu.adp.widget.ListView.am {
    LinearLayout aMI;
    TextView aMJ;
    HeadImageView aMK;
    TextView aML;
    TextView aMM;
    TextView mTitle;

    public at(View view) {
        super(view);
        this.aMI = (LinearLayout) view.findViewById(com.baidu.tieba.q.app_parent);
        this.mTitle = (TextView) view.findViewById(com.baidu.tieba.q.app_name);
        this.aML = (TextView) view.findViewById(com.baidu.tieba.q.app_desc);
        this.aMK = (HeadImageView) view.findViewById(com.baidu.tieba.q.app_icon);
        this.aMM = (TextView) view.findViewById(com.baidu.tieba.q.app_download);
        this.aMJ = (TextView) view.findViewById(com.baidu.tieba.q.recommend_app);
    }
}
