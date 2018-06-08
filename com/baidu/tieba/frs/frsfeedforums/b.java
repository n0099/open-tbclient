package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b {
    public int ayX = 3;
    public View bFh;
    public View bmp;
    public BarImageView dqA;
    public TextView dqB;
    public TextView dqC;
    public EntelechyUserLikeButton dqD;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.bmp = view;
        this.dqA = (BarImageView) view.findViewById(d.g.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(d.g.frs_feed_forum_title);
        this.dqB = (TextView) view.findViewById(d.g.frs_feed_forum_other_info);
        this.dqC = (TextView) view.findViewById(d.g.frs_feed_forum_related);
        this.dqD = (EntelechyUserLikeButton) view.findViewById(d.g.frs_feed_forum_attention);
        this.bFh = view.findViewById(d.g.frs_feed_forum_divider);
    }
}
