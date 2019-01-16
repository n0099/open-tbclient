package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b {
    public int aMj = 3;
    public View bDo;
    public BarImageView dWh;
    public TextView dWi;
    public TextView dWj;
    public EntelechyUserLikeButton dWk;
    public View mDivider;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.bDo = view;
        this.dWh = (BarImageView) view.findViewById(e.g.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(e.g.frs_feed_forum_title);
        this.dWi = (TextView) view.findViewById(e.g.frs_feed_forum_other_info);
        this.dWj = (TextView) view.findViewById(e.g.frs_feed_forum_related);
        this.dWk = (EntelechyUserLikeButton) view.findViewById(e.g.frs_feed_forum_attention);
        this.mDivider = view.findViewById(e.g.frs_feed_forum_divider);
    }
}
