package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class bl extends x.a {
    TextView aPf;
    LinearLayout aVO;
    TextView aVP;
    HeadImageView aVQ;
    TextView aVR;
    TextView aVS;

    public bl(View view) {
        super(view);
        this.aVO = (LinearLayout) view.findViewById(i.f.app_parent);
        this.aPf = (TextView) view.findViewById(i.f.app_name);
        this.aVR = (TextView) view.findViewById(i.f.app_desc);
        this.aVQ = (HeadImageView) view.findViewById(i.f.app_icon);
        this.aVS = (TextView) view.findViewById(i.f.app_download);
        this.aVP = (TextView) view.findViewById(i.f.recommend_app);
    }
}
