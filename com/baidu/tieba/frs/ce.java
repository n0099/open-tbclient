package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ce {
    public View aJB;
    public TextView aOG;
    public View aPI;
    public int aej = 3;
    public BarImageView biP;
    public TextView biQ;
    public TextView biR;
    public TextView biS;
    public int position;

    public ce(View view) {
        this.aJB = view;
        this.biP = (BarImageView) view.findViewById(t.g.frs_feed_forum_image);
        this.aOG = (TextView) view.findViewById(t.g.frs_feed_forum_title);
        this.biQ = (TextView) view.findViewById(t.g.frs_feed_forum_other_info);
        this.biR = (TextView) view.findViewById(t.g.frs_feed_forum_related);
        this.biS = (TextView) view.findViewById(t.g.frs_feed_forum_attention);
        this.aPI = view.findViewById(t.g.frs_feed_forum_divider);
    }
}
