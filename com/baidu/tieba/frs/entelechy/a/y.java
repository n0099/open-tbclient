package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class y extends v.a {
    public TextView dvo;
    public ImageView fDR;
    public TextView fDS;
    public ImageView fDT;
    public View fDU;
    public View fDV;

    public y(View view) {
        super(view);
        if (view != null) {
            this.dvo = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.fDR = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.fDS = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.fDT = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.fDU = view.findViewById(R.id.top_divider_line);
            this.fDV = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
