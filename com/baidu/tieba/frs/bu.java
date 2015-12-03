package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class bu {
    public View aHS;
    public TextView aUB;
    public View aWS;
    public int afY = 3;
    public BarImageView bbU;
    public TextView bbV;
    public TextView bbW;
    public TextView bbX;
    public int position;

    public bu(View view) {
        this.aHS = view;
        this.bbU = (BarImageView) view.findViewById(n.f.frs_feed_forum_image);
        this.aUB = (TextView) view.findViewById(n.f.frs_feed_forum_title);
        this.bbV = (TextView) view.findViewById(n.f.frs_feed_forum_other_info);
        this.bbW = (TextView) view.findViewById(n.f.frs_feed_forum_related);
        this.bbX = (TextView) view.findViewById(n.f.frs_feed_forum_attention);
        this.aWS = view.findViewById(n.f.frs_feed_forum_divider);
    }
}
