package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b {
    public int azP = 3;
    public View bHc;
    public View bnO;
    public BarImageView dtJ;
    public TextView dtK;
    public TextView dtL;
    public EntelechyUserLikeButton dtM;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.bnO = view;
        this.dtJ = (BarImageView) view.findViewById(d.g.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(d.g.frs_feed_forum_title);
        this.dtK = (TextView) view.findViewById(d.g.frs_feed_forum_other_info);
        this.dtL = (TextView) view.findViewById(d.g.frs_feed_forum_related);
        this.dtM = (EntelechyUserLikeButton) view.findViewById(d.g.frs_feed_forum_attention);
        this.bHc = view.findViewById(d.g.frs_feed_forum_divider);
    }
}
