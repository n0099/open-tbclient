package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class cf {
    public View aNr;
    public TextView aSh;
    public View aTu;
    public int aik = 3;
    public BarImageView bnm;
    public TextView bnn;
    public TextView bno;
    public TextView bnp;
    public int position;

    public cf(View view) {
        this.aNr = view;
        this.bnm = (BarImageView) view.findViewById(t.g.frs_feed_forum_image);
        this.aSh = (TextView) view.findViewById(t.g.frs_feed_forum_title);
        this.bnn = (TextView) view.findViewById(t.g.frs_feed_forum_other_info);
        this.bno = (TextView) view.findViewById(t.g.frs_feed_forum_related);
        this.bnp = (TextView) view.findViewById(t.g.frs_feed_forum_attention);
        this.aTu = view.findViewById(t.g.frs_feed_forum_divider);
    }
}
