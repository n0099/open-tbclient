package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b {
    public int ahx = 3;
    public View eZS;
    public BarImageView hMS;
    public TextView hMT;
    public TextView hMU;
    public EntelechyUserLikeButton hMV;
    public View mDivider;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.eZS = view;
        this.hMS = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.hMT = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.hMU = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.hMV = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.mDivider = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
