package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class s extends r.a {
    public ImageView dHV;
    public TextView dHW;
    public ImageView dHX;
    public View dHY;
    public View dHZ;
    public TextView mTitleTv;

    public s(View view) {
        super(view);
        if (view != null) {
            this.mTitleTv = (TextView) view.findViewById(d.g.video_activity_item_title);
            this.dHV = (ImageView) view.findViewById(d.g.video_activity_item_tip);
            this.dHW = (TextView) view.findViewById(d.g.video_activity_item_type);
            this.dHX = (ImageView) view.findViewById(d.g.video_activity_item_more);
            this.dHY = view.findViewById(d.g.top_divider_line);
            this.dHZ = view.findViewById(d.g.bottom_divider_line);
        }
    }
}
