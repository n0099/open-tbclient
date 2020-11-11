package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class b {
    public int ajq = 3;
    public View fTz;
    public BarImageView iVv;
    public TextView iVw;
    public TextView iVx;
    public EntelechyUserLikeButton iVy;
    public View mDivider;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.fTz = view;
        this.iVv = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.iVw = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.iVx = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.iVy = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.mDivider = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
