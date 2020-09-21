package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class b {
    public int aiX = 3;
    public View ftd;
    public BarImageView ioj;
    public TextView iok;
    public TextView iol;
    public EntelechyUserLikeButton iom;
    public View mDivider;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.ftd = view;
        this.ioj = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.iok = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.iol = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.iom = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.mDivider = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
