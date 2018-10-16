package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class o extends q.a {
    public TextView bNW;
    public ImageView dJh;
    public TextView dJi;
    public ImageView dJj;
    public View dJk;
    public View dJl;

    public o(View view) {
        super(view);
        if (view != null) {
            this.bNW = (TextView) view.findViewById(e.g.video_activity_item_title);
            this.dJh = (ImageView) view.findViewById(e.g.video_activity_item_tip);
            this.dJi = (TextView) view.findViewById(e.g.video_activity_item_type);
            this.dJj = (ImageView) view.findViewById(e.g.video_activity_item_more);
            this.dJk = view.findViewById(e.g.top_divider_line);
            this.dJl = view.findViewById(e.g.bottom_divider_line);
        }
    }
}
