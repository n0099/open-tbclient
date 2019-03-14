package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class x extends v.a {
    public TextView dio;
    public ImageView fhY;
    public TextView fhZ;
    public ImageView fia;
    public View fib;
    public View fic;

    public x(View view) {
        super(view);
        if (view != null) {
            this.dio = (TextView) view.findViewById(d.g.video_activity_item_title);
            this.fhY = (ImageView) view.findViewById(d.g.video_activity_item_tip);
            this.fhZ = (TextView) view.findViewById(d.g.video_activity_item_type);
            this.fia = (ImageView) view.findViewById(d.g.video_activity_item_more);
            this.fib = view.findViewById(d.g.top_divider_line);
            this.fic = view.findViewById(d.g.bottom_divider_line);
        }
    }
}
