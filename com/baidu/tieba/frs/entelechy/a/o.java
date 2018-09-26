package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class o extends q.a {
    public TextView bFt;
    public ImageView dBh;
    public TextView dBi;
    public ImageView dBj;
    public View dBk;
    public View dBl;

    public o(View view) {
        super(view);
        if (view != null) {
            this.bFt = (TextView) view.findViewById(e.g.video_activity_item_title);
            this.dBh = (ImageView) view.findViewById(e.g.video_activity_item_tip);
            this.dBi = (TextView) view.findViewById(e.g.video_activity_item_type);
            this.dBj = (ImageView) view.findViewById(e.g.video_activity_item_more);
            this.dBk = view.findViewById(e.g.top_divider_line);
            this.dBl = view.findViewById(e.g.bottom_divider_line);
        }
    }
}
