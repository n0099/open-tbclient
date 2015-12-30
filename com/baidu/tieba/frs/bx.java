package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class bx {
    public View aJq;
    public View aOM;
    public TextView aOn;
    public int ahf = 3;
    public BarImageView bfT;
    public TextView bfU;
    public TextView bfV;
    public TextView bfW;
    public int position;

    public bx(View view) {
        this.aJq = view;
        this.bfT = (BarImageView) view.findViewById(n.g.frs_feed_forum_image);
        this.aOn = (TextView) view.findViewById(n.g.frs_feed_forum_title);
        this.bfU = (TextView) view.findViewById(n.g.frs_feed_forum_other_info);
        this.bfV = (TextView) view.findViewById(n.g.frs_feed_forum_related);
        this.bfW = (TextView) view.findViewById(n.g.frs_feed_forum_attention);
        this.aOM = view.findViewById(n.g.frs_feed_forum_divider);
    }
}
