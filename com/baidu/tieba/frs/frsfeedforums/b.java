package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b {
    public int ajU = 3;
    public View dBb;
    public View giF;
    public BarImageView jxv;
    public TextView jxw;
    public TextView jxx;
    public EntelechyUserLikeButton jxy;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.giF = view;
        this.jxv = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.jxw = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.jxx = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.jxy = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.dBb = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
