package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {
    public View bgU;
    public int csg = 3;
    public View diF;
    public BarImageView fFR;
    public TextView fFS;
    public TextView fFT;
    public EntelechyUserLikeButton fFU;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.diF = view;
        this.fFR = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.fFS = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.fFT = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.fFU = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.bgU = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
