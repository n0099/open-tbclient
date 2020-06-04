package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class af extends aa.a {
    public TextView eTO;
    public ImageView hxg;
    public TextView hxh;
    public ImageView hxi;
    public View hxj;
    public View hxk;

    public af(View view) {
        super(view);
        if (view != null) {
            this.eTO = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.hxg = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.hxh = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.hxi = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.hxj = view.findViewById(R.id.top_divider_line);
            this.hxk = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
