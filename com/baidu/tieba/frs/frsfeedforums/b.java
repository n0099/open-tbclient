package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {
    public View bhm;
    public int csX = 3;
    public View djw;
    public BarImageView fGI;
    public TextView fGJ;
    public TextView fGK;
    public EntelechyUserLikeButton fGL;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.djw = view;
        this.fGI = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.fGJ = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.fGK = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.fGL = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.bhm = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
