package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class q extends r.a {
    public ImageView dLf;
    public TextView dLg;
    public ImageView dLh;
    public View dLi;
    public View dLj;
    public TextView mTitleTv;

    public q(View view) {
        super(view);
        if (view != null) {
            this.mTitleTv = (TextView) view.findViewById(d.g.video_activity_item_title);
            this.dLf = (ImageView) view.findViewById(d.g.video_activity_item_tip);
            this.dLg = (TextView) view.findViewById(d.g.video_activity_item_type);
            this.dLh = (ImageView) view.findViewById(d.g.video_activity_item_more);
            this.dLi = view.findViewById(d.g.top_divider_line);
            this.dLj = view.findViewById(d.g.bottom_divider_line);
        }
    }
}
