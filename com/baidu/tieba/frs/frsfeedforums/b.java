package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b {
    public int Ni = 3;
    public View eaC;
    public EntelechyUserLikeButton gzA;
    public BarImageView gzx;
    public TextView gzy;
    public TextView gzz;
    public View mDivider;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.eaC = view;
        this.gzx = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.gzy = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.gzz = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.gzA = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.mDivider = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
