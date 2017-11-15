package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class r extends j.a {
    public ImageView cEZ;
    public TextView cFa;
    public ImageView cFb;
    public View cFc;
    public View cFd;
    public TextView mTitleTv;

    public r(View view) {
        super(view);
        if (view != null) {
            this.mTitleTv = (TextView) view.findViewById(d.g.video_activity_item_title);
            this.cEZ = (ImageView) view.findViewById(d.g.video_activity_item_tip);
            this.cFa = (TextView) view.findViewById(d.g.video_activity_item_type);
            this.cFb = (ImageView) view.findViewById(d.g.video_activity_item_more);
            this.cFc = view.findViewById(d.g.top_divider_line);
            this.cFd = view.findViewById(d.g.bottom_divider_line);
        }
    }
}
