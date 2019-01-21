package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class o extends q.a {
    public TextView bTn;
    public ImageView dUm;
    public TextView dUn;
    public ImageView dUo;
    public View dUp;
    public View dUq;

    public o(View view) {
        super(view);
        if (view != null) {
            this.bTn = (TextView) view.findViewById(e.g.video_activity_item_title);
            this.dUm = (ImageView) view.findViewById(e.g.video_activity_item_tip);
            this.dUn = (TextView) view.findViewById(e.g.video_activity_item_type);
            this.dUo = (ImageView) view.findViewById(e.g.video_activity_item_more);
            this.dUp = view.findViewById(e.g.top_divider_line);
            this.dUq = view.findViewById(e.g.bottom_divider_line);
        }
    }
}
