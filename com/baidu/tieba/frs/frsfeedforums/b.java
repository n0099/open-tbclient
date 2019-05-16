package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {
    public View aMY;
    public View cWH;
    public int ccI = 3;
    public BarImageView fzR;
    public TextView fzS;
    public TextView fzT;
    public EntelechyUserLikeButton fzU;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.cWH = view;
        this.fzR = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.fzS = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.fzT = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.fzU = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.aMY = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
