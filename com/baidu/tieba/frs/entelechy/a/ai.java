package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class ai extends af.a {
    public View bEa;
    public View bEb;
    public TextView fSh;
    public ImageView iMO;
    public TextView iMP;
    public ImageView iMQ;

    public ai(View view) {
        super(view);
        if (view != null) {
            this.fSh = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.iMO = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.iMP = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.iMQ = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.bEa = view.findViewById(R.id.top_divider_line);
            this.bEb = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
