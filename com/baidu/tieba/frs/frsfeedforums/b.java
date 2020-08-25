package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class b {
    public int aiB = 3;
    public View fpN;
    public BarImageView ihb;
    public TextView ihc;
    public TextView ihd;
    public EntelechyUserLikeButton ihe;
    public View mDivider;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.fpN = view;
        this.ihb = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.ihc = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.ihd = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.ihe = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.mDivider = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
