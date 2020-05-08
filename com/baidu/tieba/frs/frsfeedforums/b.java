package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b {
    public int afW = 3;
    public View eAX;
    public BarImageView hkj;
    public TextView hkk;
    public TextView hkl;
    public EntelechyUserLikeButton hkm;
    public View mDivider;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.eAX = view;
        this.hkj = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.hkk = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.hkl = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.hkm = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.mDivider = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
