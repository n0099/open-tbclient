package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b {
    public int Ni = 3;
    public View eaB;
    public BarImageView gzv;
    public TextView gzw;
    public TextView gzx;
    public EntelechyUserLikeButton gzy;
    public View mDivider;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.eaB = view;
        this.gzv = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.gzw = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.gzx = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.gzy = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.mDivider = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
