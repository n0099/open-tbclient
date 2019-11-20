package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class y extends v.a {
    public TextView dCK;
    public ImageView fEe;
    public TextView fEf;
    public ImageView fEg;
    public View fEh;
    public View fEi;

    public y(View view) {
        super(view);
        if (view != null) {
            this.dCK = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.fEe = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.fEf = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.fEg = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.fEh = view.findViewById(R.id.top_divider_line);
            this.fEi = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
