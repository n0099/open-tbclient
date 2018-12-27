package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class o extends q.a {
    public TextView bSB;
    public ImageView dTF;
    public TextView dTG;
    public ImageView dTH;
    public View dTI;
    public View dTJ;

    public o(View view) {
        super(view);
        if (view != null) {
            this.bSB = (TextView) view.findViewById(e.g.video_activity_item_title);
            this.dTF = (ImageView) view.findViewById(e.g.video_activity_item_tip);
            this.dTG = (TextView) view.findViewById(e.g.video_activity_item_type);
            this.dTH = (ImageView) view.findViewById(e.g.video_activity_item_more);
            this.dTI = view.findViewById(e.g.top_divider_line);
            this.dTJ = view.findViewById(e.g.bottom_divider_line);
        }
    }
}
