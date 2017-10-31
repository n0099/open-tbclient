package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class r extends j.a {
    public ImageView cEG;
    public TextView cEH;
    public ImageView cEI;
    public View cEJ;
    public View cEK;
    public TextView mTitleTv;

    public r(View view) {
        super(view);
        if (view != null) {
            this.mTitleTv = (TextView) view.findViewById(d.g.video_activity_item_title);
            this.cEG = (ImageView) view.findViewById(d.g.video_activity_item_tip);
            this.cEH = (TextView) view.findViewById(d.g.video_activity_item_type);
            this.cEI = (ImageView) view.findViewById(d.g.video_activity_item_more);
            this.cEJ = view.findViewById(d.g.top_divider_line);
            this.cEK = view.findViewById(d.g.bottom_divider_line);
        }
    }
}
