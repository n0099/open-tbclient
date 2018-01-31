package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class s extends r.a {
    public ImageView dIq;
    public TextView dIr;
    public ImageView dIs;
    public View dIt;
    public View dIu;
    public TextView mTitleTv;

    public s(View view) {
        super(view);
        if (view != null) {
            this.mTitleTv = (TextView) view.findViewById(d.g.video_activity_item_title);
            this.dIq = (ImageView) view.findViewById(d.g.video_activity_item_tip);
            this.dIr = (TextView) view.findViewById(d.g.video_activity_item_type);
            this.dIs = (ImageView) view.findViewById(d.g.video_activity_item_more);
            this.dIt = view.findViewById(d.g.top_divider_line);
            this.dIu = view.findViewById(d.g.bottom_divider_line);
        }
    }
}
