package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class o extends q.a {
    public TextView bOH;
    public ImageView dKl;
    public TextView dKm;
    public ImageView dKn;
    public View dKo;
    public View dKp;

    public o(View view) {
        super(view);
        if (view != null) {
            this.bOH = (TextView) view.findViewById(e.g.video_activity_item_title);
            this.dKl = (ImageView) view.findViewById(e.g.video_activity_item_tip);
            this.dKm = (TextView) view.findViewById(e.g.video_activity_item_type);
            this.dKn = (ImageView) view.findViewById(e.g.video_activity_item_more);
            this.dKo = view.findViewById(e.g.top_divider_line);
            this.dKp = view.findViewById(e.g.bottom_divider_line);
        }
    }
}
