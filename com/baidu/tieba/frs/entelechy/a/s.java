package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class s extends j.a {
    public ImageView cOq;
    public TextView cOr;
    public ImageView cOs;
    public View cOt;
    public View cOu;
    public TextView mTitleTv;

    public s(View view) {
        super(view);
        if (view != null) {
            this.mTitleTv = (TextView) view.findViewById(d.g.video_activity_item_title);
            this.cOq = (ImageView) view.findViewById(d.g.video_activity_item_tip);
            this.cOr = (TextView) view.findViewById(d.g.video_activity_item_type);
            this.cOs = (ImageView) view.findViewById(d.g.video_activity_item_more);
            this.cOt = view.findViewById(d.g.top_divider_line);
            this.cOu = view.findViewById(d.g.bottom_divider_line);
        }
    }
}
