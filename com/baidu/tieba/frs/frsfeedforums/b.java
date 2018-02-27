package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b {
    public View bTY;
    public int bfz = 3;
    public View chL;
    public BarImageView dNv;
    public TextView dNw;
    public TextView dNx;
    public EntelechyUserLikeButton dNy;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.bTY = view;
        this.dNv = (BarImageView) view.findViewById(d.g.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(d.g.frs_feed_forum_title);
        this.dNw = (TextView) view.findViewById(d.g.frs_feed_forum_other_info);
        this.dNx = (TextView) view.findViewById(d.g.frs_feed_forum_related);
        this.dNy = (EntelechyUserLikeButton) view.findViewById(d.g.frs_feed_forum_attention);
        this.chL = view.findViewById(d.g.frs_feed_forum_divider);
    }
}
