package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class b {
    public int MA = 3;
    public View dWo;
    public BarImageView guk;
    public TextView gul;
    public TextView gum;
    public EntelechyUserLikeButton gun;
    public View mDivider;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.dWo = view;
        this.guk = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.gul = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.gum = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.gun = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.mDivider = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
