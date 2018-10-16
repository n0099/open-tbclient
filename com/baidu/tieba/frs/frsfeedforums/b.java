package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b {
    public int aHp = 3;
    public View byq;
    public BarImageView dLd;
    public TextView dLe;
    public TextView dLf;
    public EntelechyUserLikeButton dLg;
    public View mDivider;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.byq = view;
        this.dLd = (BarImageView) view.findViewById(e.g.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(e.g.frs_feed_forum_title);
        this.dLe = (TextView) view.findViewById(e.g.frs_feed_forum_other_info);
        this.dLf = (TextView) view.findViewById(e.g.frs_feed_forum_related);
        this.dLg = (EntelechyUserLikeButton) view.findViewById(e.g.frs_feed_forum_attention);
        this.mDivider = view.findViewById(e.g.frs_feed_forum_divider);
    }
}
