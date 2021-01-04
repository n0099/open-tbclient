package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b {
    public int akW = 3;
    public View dDI;
    public View gkJ;
    public BarImageView jwh;
    public TextView jwi;
    public TextView jwj;
    public EntelechyUserLikeButton jwk;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.gkJ = view;
        this.jwh = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.jwi = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.jwj = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.jwk = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.dDI = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
