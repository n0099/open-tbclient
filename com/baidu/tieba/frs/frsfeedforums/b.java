package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b {
    public int azI = 3;
    public View bHR;
    public View bou;
    public BarImageView dww;
    public TextView dwx;
    public TextView dwy;
    public EntelechyUserLikeButton dwz;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.bou = view;
        this.dww = (BarImageView) view.findViewById(d.g.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(d.g.frs_feed_forum_title);
        this.dwx = (TextView) view.findViewById(d.g.frs_feed_forum_other_info);
        this.dwy = (TextView) view.findViewById(d.g.frs_feed_forum_related);
        this.dwz = (EntelechyUserLikeButton) view.findViewById(d.g.frs_feed_forum_attention);
        this.bHR = view.findViewById(d.g.frs_feed_forum_divider);
    }
}
