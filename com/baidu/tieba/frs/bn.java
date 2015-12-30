package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class bn extends x.a {
    TextView aOn;
    TextView bfA;
    LinearLayout bfw;
    TextView bfx;
    HeadImageView bfy;
    TextView bfz;

    public bn(View view) {
        super(view);
        this.bfw = (LinearLayout) view.findViewById(n.g.app_parent);
        this.aOn = (TextView) view.findViewById(n.g.app_name);
        this.bfz = (TextView) view.findViewById(n.g.app_desc);
        this.bfy = (HeadImageView) view.findViewById(n.g.app_icon);
        this.bfA = (TextView) view.findViewById(n.g.app_download);
        this.bfx = (TextView) view.findViewById(n.g.recommend_app);
    }
}
