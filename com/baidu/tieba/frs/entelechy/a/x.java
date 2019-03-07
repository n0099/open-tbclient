package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class x extends v.a {
    public TextView dis;
    public ImageView fhZ;
    public TextView fia;
    public ImageView fib;
    public View fic;
    public View fie;

    public x(View view) {
        super(view);
        if (view != null) {
            this.dis = (TextView) view.findViewById(d.g.video_activity_item_title);
            this.fhZ = (ImageView) view.findViewById(d.g.video_activity_item_tip);
            this.fia = (TextView) view.findViewById(d.g.video_activity_item_type);
            this.fib = (ImageView) view.findViewById(d.g.video_activity_item_more);
            this.fic = view.findViewById(d.g.top_divider_line);
            this.fie = view.findViewById(d.g.bottom_divider_line);
        }
    }
}
