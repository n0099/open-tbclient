package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ba extends x.a {
    TextView aPV;
    LinearLayout aVY;
    TextView aVZ;
    HeadImageView aWa;
    TextView aWb;
    TextView aWc;

    public ba(View view) {
        super(view);
        this.aVY = (LinearLayout) view.findViewById(i.f.app_parent);
        this.aPV = (TextView) view.findViewById(i.f.app_name);
        this.aWb = (TextView) view.findViewById(i.f.app_desc);
        this.aWa = (HeadImageView) view.findViewById(i.f.app_icon);
        this.aWc = (TextView) view.findViewById(i.f.app_download);
        this.aVZ = (TextView) view.findViewById(i.f.recommend_app);
    }
}
