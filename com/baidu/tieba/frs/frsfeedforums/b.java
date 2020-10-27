package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class b {
    public int ajq = 3;
    public View fNJ;
    public TextView iPA;
    public EntelechyUserLikeButton iPB;
    public BarImageView iPy;
    public TextView iPz;
    public View mDivider;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.fNJ = view;
        this.iPy = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.iPz = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.iPA = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.iPB = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.mDivider = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
