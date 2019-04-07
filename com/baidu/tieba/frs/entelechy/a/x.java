package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class x extends v.a {
    public TextView dir;
    public ImageView fhK;
    public TextView fhL;
    public ImageView fhM;
    public View fhN;
    public View fhO;

    public x(View view) {
        super(view);
        if (view != null) {
            this.dir = (TextView) view.findViewById(d.g.video_activity_item_title);
            this.fhK = (ImageView) view.findViewById(d.g.video_activity_item_tip);
            this.fhL = (TextView) view.findViewById(d.g.video_activity_item_type);
            this.fhM = (ImageView) view.findViewById(d.g.video_activity_item_more);
            this.fhN = view.findViewById(d.g.top_divider_line);
            this.fhO = view.findViewById(d.g.bottom_divider_line);
        }
    }
}
