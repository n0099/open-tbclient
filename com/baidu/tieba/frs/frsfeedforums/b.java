package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class b {
    public int aho = 3;
    public View feu;
    public BarImageView hST;
    public TextView hSU;
    public TextView hSV;
    public EntelechyUserLikeButton hSW;
    public View mDivider;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.feu = view;
        this.hST = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.hSU = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.hSV = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.hSW = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.mDivider = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
