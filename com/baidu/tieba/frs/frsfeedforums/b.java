package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b {
    public int aMk = 3;
    public View bDp;
    public BarImageView dWi;
    public TextView dWj;
    public TextView dWk;
    public EntelechyUserLikeButton dWl;
    public View mDivider;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.bDp = view;
        this.dWi = (BarImageView) view.findViewById(e.g.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(e.g.frs_feed_forum_title);
        this.dWj = (TextView) view.findViewById(e.g.frs_feed_forum_other_info);
        this.dWk = (TextView) view.findViewById(e.g.frs_feed_forum_related);
        this.dWl = (EntelechyUserLikeButton) view.findViewById(e.g.frs_feed_forum_attention);
        this.mDivider = view.findViewById(e.g.frs_feed_forum_divider);
    }
}
