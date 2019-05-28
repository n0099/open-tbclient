package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class y extends v.a {
    public TextView dsZ;
    public ImageView fyh;
    public TextView fyi;
    public ImageView fyj;
    public View fyk;
    public View fyl;

    public y(View view) {
        super(view);
        if (view != null) {
            this.dsZ = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.fyh = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.fyi = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.fyj = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.fyk = view.findViewById(R.id.top_divider_line);
            this.fyl = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
