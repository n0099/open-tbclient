package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class y extends v.a {
    public TextView dsY;
    public ImageView fyg;
    public TextView fyh;
    public ImageView fyi;
    public View fyj;
    public View fyk;

    public y(View view) {
        super(view);
        if (view != null) {
            this.dsY = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.fyg = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.fyh = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.fyi = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.fyj = view.findViewById(R.id.top_divider_line);
            this.fyk = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
