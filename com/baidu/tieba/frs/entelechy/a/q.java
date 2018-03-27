package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class q extends r.a {
    public ImageView dLk;
    public TextView dLl;
    public ImageView dLm;
    public View dLn;
    public View dLo;
    public TextView mTitleTv;

    public q(View view) {
        super(view);
        if (view != null) {
            this.mTitleTv = (TextView) view.findViewById(d.g.video_activity_item_title);
            this.dLk = (ImageView) view.findViewById(d.g.video_activity_item_tip);
            this.dLl = (TextView) view.findViewById(d.g.video_activity_item_type);
            this.dLm = (ImageView) view.findViewById(d.g.video_activity_item_more);
            this.dLn = view.findViewById(d.g.top_divider_line);
            this.dLo = view.findViewById(d.g.bottom_divider_line);
        }
    }
}
