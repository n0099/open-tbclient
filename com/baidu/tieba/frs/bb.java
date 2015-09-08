package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class bb extends x.a {
    TextView aQj;
    LinearLayout aWp;
    TextView aWq;
    HeadImageView aWr;
    TextView aWs;
    TextView aWt;

    public bb(View view) {
        super(view);
        this.aWp = (LinearLayout) view.findViewById(i.f.app_parent);
        this.aQj = (TextView) view.findViewById(i.f.app_name);
        this.aWs = (TextView) view.findViewById(i.f.app_desc);
        this.aWr = (HeadImageView) view.findViewById(i.f.app_icon);
        this.aWt = (TextView) view.findViewById(i.f.app_download);
        this.aWq = (TextView) view.findViewById(i.f.recommend_app);
    }
}
