package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class o extends q.a {
    public TextView bTm;
    public ImageView dUl;
    public TextView dUm;
    public ImageView dUn;
    public View dUo;
    public View dUp;

    public o(View view) {
        super(view);
        if (view != null) {
            this.bTm = (TextView) view.findViewById(e.g.video_activity_item_title);
            this.dUl = (ImageView) view.findViewById(e.g.video_activity_item_tip);
            this.dUm = (TextView) view.findViewById(e.g.video_activity_item_type);
            this.dUn = (ImageView) view.findViewById(e.g.video_activity_item_more);
            this.dUo = view.findViewById(e.g.top_divider_line);
            this.dUp = view.findViewById(e.g.bottom_divider_line);
        }
    }
}
