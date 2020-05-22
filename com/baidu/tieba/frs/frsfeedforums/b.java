package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b {
    public int agt = 3;
    public View ePw;
    public BarImageView hyX;
    public TextView hyY;
    public TextView hyZ;
    public EntelechyUserLikeButton hza;
    public View mDivider;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.ePw = view;
        this.hyX = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.hyY = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.hyZ = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.hza = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.mDivider = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
