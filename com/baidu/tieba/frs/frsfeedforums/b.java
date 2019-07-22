package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {
    public View aNH;
    public View cYf;
    public int cdL = 3;
    public BarImageView fEQ;
    public TextView fER;
    public TextView fES;
    public EntelechyUserLikeButton fET;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.cYf = view;
        this.fEQ = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.fER = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.fES = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.fET = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.aNH = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
