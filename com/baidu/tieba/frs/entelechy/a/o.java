package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class o extends q.a {
    public TextView byV;
    public ImageView drQ;
    public TextView drR;
    public ImageView drS;
    public View drT;
    public View drU;

    public o(View view) {
        super(view);
        if (view != null) {
            this.byV = (TextView) view.findViewById(d.g.video_activity_item_title);
            this.drQ = (ImageView) view.findViewById(d.g.video_activity_item_tip);
            this.drR = (TextView) view.findViewById(d.g.video_activity_item_type);
            this.drS = (ImageView) view.findViewById(d.g.video_activity_item_more);
            this.drT = view.findViewById(d.g.top_divider_line);
            this.drU = view.findViewById(d.g.bottom_divider_line);
        }
    }
}
