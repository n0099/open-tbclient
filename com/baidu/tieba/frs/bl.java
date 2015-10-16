package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class bl extends x.a {
    TextView aPq;
    LinearLayout aVZ;
    TextView aWa;
    HeadImageView aWb;
    TextView aWc;
    TextView aWd;

    public bl(View view) {
        super(view);
        this.aVZ = (LinearLayout) view.findViewById(i.f.app_parent);
        this.aPq = (TextView) view.findViewById(i.f.app_name);
        this.aWc = (TextView) view.findViewById(i.f.app_desc);
        this.aWb = (HeadImageView) view.findViewById(i.f.app_icon);
        this.aWd = (TextView) view.findViewById(i.f.app_download);
        this.aWa = (TextView) view.findViewById(i.f.recommend_app);
    }
}
