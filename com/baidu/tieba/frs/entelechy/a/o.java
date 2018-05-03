package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class o extends q.a {
    public ImageView dek;
    public TextView del;
    public ImageView dem;
    public View den;
    public View deo;
    public TextView mTitleTv;

    public o(View view2) {
        super(view2);
        if (view2 != null) {
            this.mTitleTv = (TextView) view2.findViewById(d.g.video_activity_item_title);
            this.dek = (ImageView) view2.findViewById(d.g.video_activity_item_tip);
            this.del = (TextView) view2.findViewById(d.g.video_activity_item_type);
            this.dem = (ImageView) view2.findViewById(d.g.video_activity_item_more);
            this.den = view2.findViewById(d.g.top_divider_line);
            this.deo = view2.findViewById(d.g.bottom_divider_line);
        }
    }
}
