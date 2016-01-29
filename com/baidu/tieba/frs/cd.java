package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class cd {
    public View aKv;
    public TextView aPr;
    public View aQL;
    public int ahU = 3;
    public BarImageView biB;
    public TextView biC;
    public TextView biD;
    public TextView biE;
    public int position;

    public cd(View view) {
        this.aKv = view;
        this.biB = (BarImageView) view.findViewById(t.g.frs_feed_forum_image);
        this.aPr = (TextView) view.findViewById(t.g.frs_feed_forum_title);
        this.biC = (TextView) view.findViewById(t.g.frs_feed_forum_other_info);
        this.biD = (TextView) view.findViewById(t.g.frs_feed_forum_related);
        this.biE = (TextView) view.findViewById(t.g.frs_feed_forum_attention);
        this.aQL = view.findViewById(t.g.frs_feed_forum_divider);
    }
}
