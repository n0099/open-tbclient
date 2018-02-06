package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class q extends r.a {
    public ImageView dLr;
    public TextView dLs;
    public ImageView dLt;
    public View dLu;
    public View dLv;
    public TextView mTitleTv;

    public q(View view) {
        super(view);
        if (view != null) {
            this.mTitleTv = (TextView) view.findViewById(d.g.video_activity_item_title);
            this.dLr = (ImageView) view.findViewById(d.g.video_activity_item_tip);
            this.dLs = (TextView) view.findViewById(d.g.video_activity_item_type);
            this.dLt = (ImageView) view.findViewById(d.g.video_activity_item_more);
            this.dLu = view.findViewById(d.g.top_divider_line);
            this.dLv = view.findViewById(d.g.bottom_divider_line);
        }
    }
}
