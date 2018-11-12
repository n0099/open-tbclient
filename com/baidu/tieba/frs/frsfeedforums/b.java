package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b {
    public int aIf = 3;
    public View bzb;
    public BarImageView dMh;
    public TextView dMi;
    public TextView dMj;
    public EntelechyUserLikeButton dMk;
    public View mDivider;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.bzb = view;
        this.dMh = (BarImageView) view.findViewById(e.g.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(e.g.frs_feed_forum_title);
        this.dMi = (TextView) view.findViewById(e.g.frs_feed_forum_other_info);
        this.dMj = (TextView) view.findViewById(e.g.frs_feed_forum_related);
        this.dMk = (EntelechyUserLikeButton) view.findViewById(e.g.frs_feed_forum_attention);
        this.mDivider = view.findViewById(e.g.frs_feed_forum_divider);
    }
}
