package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class bk extends x.a {
    TextView aUB;
    TextView bbA;
    TextView bbB;
    LinearLayout bbx;
    TextView bby;
    HeadImageView bbz;

    public bk(View view) {
        super(view);
        this.bbx = (LinearLayout) view.findViewById(n.f.app_parent);
        this.aUB = (TextView) view.findViewById(n.f.app_name);
        this.bbA = (TextView) view.findViewById(n.f.app_desc);
        this.bbz = (HeadImageView) view.findViewById(n.f.app_icon);
        this.bbB = (TextView) view.findViewById(n.f.app_download);
        this.bby = (TextView) view.findViewById(n.f.recommend_app);
    }
}
