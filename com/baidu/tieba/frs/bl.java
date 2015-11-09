package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class bl extends x.a {
    TextView aPy;
    LinearLayout aWh;
    TextView aWi;
    HeadImageView aWj;
    TextView aWk;
    TextView aWl;

    public bl(View view) {
        super(view);
        this.aWh = (LinearLayout) view.findViewById(i.f.app_parent);
        this.aPy = (TextView) view.findViewById(i.f.app_name);
        this.aWk = (TextView) view.findViewById(i.f.app_desc);
        this.aWj = (HeadImageView) view.findViewById(i.f.app_icon);
        this.aWl = (TextView) view.findViewById(i.f.app_download);
        this.aWi = (TextView) view.findViewById(i.f.recommend_app);
    }
}
