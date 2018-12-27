package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b {
    public int aLH = 3;
    public View bCB;
    public BarImageView dVB;
    public TextView dVC;
    public TextView dVD;
    public EntelechyUserLikeButton dVE;
    public View mDivider;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.bCB = view;
        this.dVB = (BarImageView) view.findViewById(e.g.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(e.g.frs_feed_forum_title);
        this.dVC = (TextView) view.findViewById(e.g.frs_feed_forum_other_info);
        this.dVD = (TextView) view.findViewById(e.g.frs_feed_forum_related);
        this.dVE = (EntelechyUserLikeButton) view.findViewById(e.g.frs_feed_forum_attention);
        this.mDivider = view.findViewById(e.g.frs_feed_forum_divider);
    }
}
