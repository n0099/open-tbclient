package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class s extends j.a {
    public ImageView cOu;
    public TextView cOv;
    public ImageView cOw;
    public View cOx;
    public View cOy;
    public TextView mTitleTv;

    public s(View view) {
        super(view);
        if (view != null) {
            this.mTitleTv = (TextView) view.findViewById(d.g.video_activity_item_title);
            this.cOu = (ImageView) view.findViewById(d.g.video_activity_item_tip);
            this.cOv = (TextView) view.findViewById(d.g.video_activity_item_type);
            this.cOw = (ImageView) view.findViewById(d.g.video_activity_item_more);
            this.cOx = view.findViewById(d.g.top_divider_line);
            this.cOy = view.findViewById(d.g.bottom_divider_line);
        }
    }
}
