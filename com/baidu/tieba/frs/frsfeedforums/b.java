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
    public BarImageView hSR;
    public TextView hSS;
    public TextView hST;
    public EntelechyUserLikeButton hSU;
    public View mDivider;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.feu = view;
        this.hSR = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.hSS = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.hST = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.hSU = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.mDivider = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
