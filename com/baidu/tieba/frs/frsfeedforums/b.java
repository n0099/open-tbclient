package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b {
    public View bUb;
    public int bfC = 3;
    public View chO;
    public BarImageView dNA;
    public TextView dNB;
    public TextView dNC;
    public EntelechyUserLikeButton dND;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.bUb = view;
        this.dNA = (BarImageView) view.findViewById(d.g.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(d.g.frs_feed_forum_title);
        this.dNB = (TextView) view.findViewById(d.g.frs_feed_forum_other_info);
        this.dNC = (TextView) view.findViewById(d.g.frs_feed_forum_related);
        this.dND = (EntelechyUserLikeButton) view.findViewById(d.g.frs_feed_forum_attention);
        this.chO = view.findViewById(d.g.frs_feed_forum_divider);
    }
}
