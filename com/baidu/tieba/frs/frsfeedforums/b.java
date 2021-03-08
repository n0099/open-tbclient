package com.baidu.tieba.frs.frsfeedforums;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b {
    public int aln = 3;
    public View dCC;
    public View gki;
    public BarImageView jze;
    public TextView jzf;
    public TextView jzg;
    public EntelechyUserLikeButton jzh;
    public TextView mTitle;
    public int position;

    public b(View view) {
        this.gki = view;
        this.jze = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.mTitle = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.jzf = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.jzg = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.jzh = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.dCC = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
