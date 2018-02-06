package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b {
    public View bUk;
    public int bfL = 3;
    public View chX;
    public BarImageView dNH;
    public TextView dNI;
    public TextView dNJ;
    public EntelechyUserLikeButton dNK;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.bUk = view;
        this.dNH = (BarImageView) view.findViewById(d.g.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(d.g.frs_feed_forum_title);
        this.dNI = (TextView) view.findViewById(d.g.frs_feed_forum_other_info);
        this.dNJ = (TextView) view.findViewById(d.g.frs_feed_forum_related);
        this.dNK = (EntelechyUserLikeButton) view.findViewById(d.g.frs_feed_forum_attention);
        this.chX = view.findViewById(d.g.frs_feed_forum_divider);
    }
}
