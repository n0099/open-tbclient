package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class b {
    public int ajv = 3;
    public View fTg;
    public BarImageView iWh;
    public TextView iWi;
    public TextView iWj;
    public EntelechyUserLikeButton iWk;
    public View mDivider;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.fTg = view;
        this.iWh = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.iWi = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.iWj = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.iWk = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.mDivider = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
