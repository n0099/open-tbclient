package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {
    public View aOf;
    public View cZX;
    public int ceL = 3;
    public BarImageView fHt;
    public TextView fHu;
    public TextView fHv;
    public EntelechyUserLikeButton fHw;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.cZX = view;
        this.fHt = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.fHu = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.fHv = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.fHw = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.aOf = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
