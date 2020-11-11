package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class ai extends af.a {
    public View bJH;
    public View bJI;
    public TextView fXX;
    public ImageView iSL;
    public TextView iSM;
    public ImageView iSN;

    public ai(View view) {
        super(view);
        if (view != null) {
            this.fXX = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.iSL = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.iSM = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.iSN = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.bJH = view.findViewById(R.id.top_divider_line);
            this.bJI = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
