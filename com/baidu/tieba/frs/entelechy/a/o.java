package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class o extends q.a {
    public TextView bzE;
    public ImageView duA;
    public TextView duB;
    public ImageView duC;
    public View duD;
    public View duE;

    public o(View view) {
        super(view);
        if (view != null) {
            this.bzE = (TextView) view.findViewById(f.g.video_activity_item_title);
            this.duA = (ImageView) view.findViewById(f.g.video_activity_item_tip);
            this.duB = (TextView) view.findViewById(f.g.video_activity_item_type);
            this.duC = (ImageView) view.findViewById(f.g.video_activity_item_more);
            this.duD = view.findViewById(f.g.top_divider_line);
            this.duE = view.findViewById(f.g.bottom_divider_line);
        }
    }
}
