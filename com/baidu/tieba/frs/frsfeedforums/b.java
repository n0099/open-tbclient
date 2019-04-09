package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class b {
    public View aLf;
    public int bUN = 3;
    public View cOw;
    public BarImageView fjw;
    public TextView fjx;
    public TextView fjy;
    public EntelechyUserLikeButton fjz;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.cOw = view;
        this.fjw = (BarImageView) view.findViewById(d.g.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(d.g.frs_feed_forum_title);
        this.fjx = (TextView) view.findViewById(d.g.frs_feed_forum_other_info);
        this.fjy = (TextView) view.findViewById(d.g.frs_feed_forum_related);
        this.fjz = (EntelechyUserLikeButton) view.findViewById(d.g.frs_feed_forum_attention);
        this.aLf = view.findViewById(d.g.frs_feed_forum_divider);
    }
}
