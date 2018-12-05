package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b {
    public int aLF = 3;
    public View bCy;
    public BarImageView dSK;
    public TextView dSL;
    public TextView dSM;
    public EntelechyUserLikeButton dSN;
    public View mDivider;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.bCy = view;
        this.dSK = (BarImageView) view.findViewById(e.g.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(e.g.frs_feed_forum_title);
        this.dSL = (TextView) view.findViewById(e.g.frs_feed_forum_other_info);
        this.dSM = (TextView) view.findViewById(e.g.frs_feed_forum_related);
        this.dSN = (EntelechyUserLikeButton) view.findViewById(e.g.frs_feed_forum_attention);
        this.mDivider = view.findViewById(e.g.frs_feed_forum_divider);
    }
}
