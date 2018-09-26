package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b {
    public int aCJ = 3;
    public View bNG;
    public View bum;
    public BarImageView dDd;
    public TextView dDe;
    public TextView dDf;
    public EntelechyUserLikeButton dDg;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.bum = view;
        this.dDd = (BarImageView) view.findViewById(e.g.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(e.g.frs_feed_forum_title);
        this.dDe = (TextView) view.findViewById(e.g.frs_feed_forum_other_info);
        this.dDf = (TextView) view.findViewById(e.g.frs_feed_forum_related);
        this.dDg = (EntelechyUserLikeButton) view.findViewById(e.g.frs_feed_forum_attention);
        this.bNG = view.findViewById(e.g.frs_feed_forum_divider);
    }
}
