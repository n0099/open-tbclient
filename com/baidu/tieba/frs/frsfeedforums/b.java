package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b {
    public int aqQ = 3;
    public View bef;
    public View bxe;
    public BarImageView dhl;
    public TextView dhm;
    public TextView dhn;
    public EntelechyUserLikeButton dho;
    public TextView mTitle;
    public int position;

    public b(View view2) {
        this.bef = view2;
        this.dhl = (BarImageView) view2.findViewById(d.g.frs_feed_forum_image);
        this.mTitle = (TextView) view2.findViewById(d.g.frs_feed_forum_title);
        this.dhm = (TextView) view2.findViewById(d.g.frs_feed_forum_other_info);
        this.dhn = (TextView) view2.findViewById(d.g.frs_feed_forum_related);
        this.dho = (EntelechyUserLikeButton) view2.findViewById(d.g.frs_feed_forum_attention);
        this.bxe = view2.findViewById(d.g.frs_feed_forum_divider);
    }
}
