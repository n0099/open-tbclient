package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class b {
    public View aLb;
    public int bUK = 3;
    public View cOt;
    public BarImageView fjK;
    public TextView fjL;
    public TextView fjM;
    public EntelechyUserLikeButton fjN;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.cOt = view;
        this.fjK = (BarImageView) view.findViewById(d.g.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(d.g.frs_feed_forum_title);
        this.fjL = (TextView) view.findViewById(d.g.frs_feed_forum_other_info);
        this.fjM = (TextView) view.findViewById(d.g.frs_feed_forum_related);
        this.fjN = (EntelechyUserLikeButton) view.findViewById(d.g.frs_feed_forum_attention);
        this.aLb = view.findViewById(d.g.frs_feed_forum_divider);
    }
}
