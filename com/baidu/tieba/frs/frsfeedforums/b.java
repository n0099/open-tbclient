package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class b {
    public int azF = 3;
    public View bHR;
    public View bow;
    public BarImageView dwt;
    public TextView dwu;
    public TextView dwv;
    public EntelechyUserLikeButton dww;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.bow = view;
        this.dwt = (BarImageView) view.findViewById(f.g.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(f.g.frs_feed_forum_title);
        this.dwu = (TextView) view.findViewById(f.g.frs_feed_forum_other_info);
        this.dwv = (TextView) view.findViewById(f.g.frs_feed_forum_related);
        this.dww = (EntelechyUserLikeButton) view.findViewById(f.g.frs_feed_forum_attention);
        this.bHR = view.findViewById(f.g.frs_feed_forum_divider);
    }
}
