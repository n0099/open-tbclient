package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b {
    public int aqQ = 3;
    public View bee;
    public View bwn;
    public BarImageView dge;
    public TextView dgf;
    public TextView dgg;
    public EntelechyUserLikeButton dgh;
    public TextView mTitle;
    public int position;

    public b(View view2) {
        this.bee = view2;
        this.dge = (BarImageView) view2.findViewById(d.g.frs_feed_forum_image);
        this.mTitle = (TextView) view2.findViewById(d.g.frs_feed_forum_title);
        this.dgf = (TextView) view2.findViewById(d.g.frs_feed_forum_other_info);
        this.dgg = (TextView) view2.findViewById(d.g.frs_feed_forum_related);
        this.dgh = (EntelechyUserLikeButton) view2.findViewById(d.g.frs_feed_forum_attention);
        this.bwn = view2.findViewById(d.g.frs_feed_forum_divider);
    }
}
