package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class b {
    public int MH = 3;
    public View dWx;
    public BarImageView gxu;
    public TextView gxv;
    public TextView gxw;
    public EntelechyUserLikeButton gxx;
    public View mDivider;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.dWx = view;
        this.gxu = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.gxv = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.gxw = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.gxx = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.mDivider = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
