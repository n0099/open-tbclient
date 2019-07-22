package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class y extends v.a {
    public TextView dvh;
    public ImageView fDd;
    public TextView fDe;
    public ImageView fDf;
    public View fDg;
    public View fDh;

    public y(View view) {
        super(view);
        if (view != null) {
            this.dvh = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.fDd = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.fDe = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.fDf = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.fDg = view.findViewById(R.id.top_divider_line);
            this.fDh = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
