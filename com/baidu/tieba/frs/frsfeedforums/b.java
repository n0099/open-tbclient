package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class b {
    public int aiD = 3;
    public View fpR;
    public BarImageView ihh;
    public TextView ihi;
    public TextView ihj;
    public EntelechyUserLikeButton ihk;
    public View mDivider;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.fpR = view;
        this.ihh = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.ihi = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.ihj = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.ihk = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.mDivider = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
