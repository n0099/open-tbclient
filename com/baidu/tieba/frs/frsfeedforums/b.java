package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class b {
    public int ajp = 3;
    public View fFo;
    public BarImageView iDc;
    public TextView iDd;
    public TextView iDe;
    public EntelechyUserLikeButton iDf;
    public View mDivider;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.fFo = view;
        this.iDc = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.iDd = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.iDe = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.iDf = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.mDivider = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
