package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class b {
    public int aku = 3;
    public View gbq;
    public BarImageView jjG;
    public TextView jjH;
    public TextView jjI;
    public EntelechyUserLikeButton jjJ;
    public View mDivider;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.gbq = view;
        this.jjG = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.jjH = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.jjI = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.jjJ = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.mDivider = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
