package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {
    public View aNH;
    public View cYm;
    public int cdS = 3;
    public BarImageView fFE;
    public TextView fFF;
    public TextView fFG;
    public EntelechyUserLikeButton fFH;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.cYm = view;
        this.fFE = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.fFF = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.fFG = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.fFH = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.aNH = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
