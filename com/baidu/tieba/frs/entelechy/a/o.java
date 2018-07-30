package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class o extends q.a {
    public TextView bzC;
    public ImageView duD;
    public TextView duE;
    public ImageView duF;
    public View duG;
    public View duH;

    public o(View view) {
        super(view);
        if (view != null) {
            this.bzC = (TextView) view.findViewById(d.g.video_activity_item_title);
            this.duD = (ImageView) view.findViewById(d.g.video_activity_item_tip);
            this.duE = (TextView) view.findViewById(d.g.video_activity_item_type);
            this.duF = (ImageView) view.findViewById(d.g.video_activity_item_more);
            this.duG = view.findViewById(d.g.top_divider_line);
            this.duH = view.findViewById(d.g.bottom_divider_line);
        }
    }
}
