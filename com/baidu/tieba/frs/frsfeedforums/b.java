package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {
    public View aMY;
    public View cWJ;
    public int ccJ = 3;
    public BarImageView fzS;
    public TextView fzT;
    public TextView fzU;
    public EntelechyUserLikeButton fzV;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.cWJ = view;
        this.fzS = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.fzT = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.fzU = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.fzV = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.aMY = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
