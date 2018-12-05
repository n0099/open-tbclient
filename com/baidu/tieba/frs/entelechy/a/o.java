package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class o extends q.a {
    public TextView bSy;
    public ImageView dQO;
    public TextView dQP;
    public ImageView dQQ;
    public View dQR;
    public View dQS;

    public o(View view) {
        super(view);
        if (view != null) {
            this.bSy = (TextView) view.findViewById(e.g.video_activity_item_title);
            this.dQO = (ImageView) view.findViewById(e.g.video_activity_item_tip);
            this.dQP = (TextView) view.findViewById(e.g.video_activity_item_type);
            this.dQQ = (ImageView) view.findViewById(e.g.video_activity_item_more);
            this.dQR = view.findViewById(e.g.top_divider_line);
            this.dQS = view.findViewById(e.g.bottom_divider_line);
        }
    }
}
